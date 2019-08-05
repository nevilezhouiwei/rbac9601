package com.nevile.base.initail;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import com.nevile.base.nevileauth.NevileAuth;
import com.nevile.base.nevileauth.NevileOperater;
import com.nevile.rbac01.pojo.AppResource;

public class ClassScaner implements ResourceLoaderAware {

	// 保存过滤规则要排除的注解
	private final List<TypeFilter> includeFilters = new LinkedList<TypeFilter>();
	private final List<TypeFilter> excludeFilters = new LinkedList<TypeFilter>();

	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
			this.resourcePatternResolver);

	public static Set<Class> scan(String[] basePackages, Class<? extends Annotation>... annotations) {
		ClassScaner cs = new ClassScaner();

		if (ArrayUtils.isNotEmpty(annotations)) {
			for (Class anno : annotations) {
				cs.addIncludeFilter(new AnnotationTypeFilter(anno));
			}
		}

		Set<Class> classes = new HashSet<Class>();
		for (String s : basePackages)
			classes.addAll(cs.doScan(s));
		return classes;
	}

	public static Set<Class> scan(String basePackages, Class<? extends Annotation>... annotations) {
		// 字符串分割成字符数组
		return ClassScaner.scan(StringUtils.tokenizeToStringArray(basePackages, ",; \t\n"), annotations);
	}

	public final ResourceLoader getResourceLoader() {
		return this.resourcePatternResolver;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
		this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
	}

	public void addIncludeFilter(TypeFilter includeFilter) {
		this.includeFilters.add(includeFilter);
	}

	public void addExcludeFilter(TypeFilter excludeFilter) {
		this.excludeFilters.add(0, excludeFilter);
	}

	public void resetFilters(boolean useDefaultFilters) {
		this.includeFilters.clear();
		this.excludeFilters.clear();
	}

	public Set<Class> doScan(String basePackage) {
		Set<Class> classes = new HashSet<Class>();
		try {
			String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
					+ org.springframework.util.ClassUtils.convertClassNameToResourcePath(
							SystemPropertyUtils.resolvePlaceholders(basePackage))
					+ "/**/*.class";
			Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);

			for (int i = 0; i < resources.length; i++) {
				Resource resource = resources[i];
				if (resource.isReadable()) {
					MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
					if ((includeFilters.size() == 0 && excludeFilters.size() == 0) || matches(metadataReader)) {
						try {
							classes.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (IOException ex) {
			throw new BeanDefinitionStoreException("I/O failure during classpath scanning", ex);
		}
		return classes;
	}

	protected boolean matches(MetadataReader metadataReader) throws IOException {
		for (TypeFilter tf : this.excludeFilters) {
			if (tf.match(metadataReader, this.metadataReaderFactory)) {
				return false;
			}
		}
		for (TypeFilter tf : this.includeFilters) {
			if (tf.match(metadataReader, this.metadataReaderFactory)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ClassScaner.scan("com.nevile", NevileAuth.class).forEach(clazz -> System.out.println(clazz));
		List<AppResource> appResource = getAppResource();
		for (AppResource appResource2 : appResource) {
			System.err.println(appResource2.toString());
		}
	}

	/*
	 * 1 定义数据库中的联合唯一约束特性 未完成 
	 * 2 先查数据库，使用模块+模块描述，或者 模块+操作+操作描述生成字符set 未完成
	 * 3 若有数据，则把数据取出后，进行中台拼接后存放hashset 
	 * 4 DB生成的权限数据与中台最新的权限数据进行比较，只做差异插入操作
	 * 5 中台生成权限数据时  完成
	 */

	public static List<AppResource> getAppResource() {
		// 资源列表
		List<AppResource> listResource = new ArrayList<AppResource>();
		// 字符化资源列表
		HashSet<String> setResource = new HashSet<String>();
		AppResource res = null;
		Set<Class> set = ClassScaner.scan("com.nevile", NevileAuth.class);
		if (null == set)
			return null;
		for (Class moduleClass : set) {
			//先生成模块名称
			AppResource AppResource = new AppResource();
			NevileAuth annotation = (NevileAuth) moduleClass.getAnnotation(NevileAuth.class);
			String authMoudle = annotation.module();
			String authMoudleDesc = annotation.desc();
			System.out.println(authMoudle + "," + authMoudleDesc);
			// 添加重复，是会有报错的，暂时不处理
			setResource.add(authMoudle + "," + authMoudleDesc);

			res = new AppResource();
			res.setResourceName(authMoudle);
			res.setResourceDes(authMoudleDesc);
			listResource.add(res);
			//寻找模块名称中方法的权限
			Method[] methods = moduleClass.getMethods();
			for (Method method : methods) {
				boolean isOperater = method.isAnnotationPresent(NevileOperater.class);
				if (isOperater) {
					NevileOperater nevileOperater = method.getAnnotation(NevileOperater.class);
					String operater = nevileOperater.operater();
					String operaterDesc = nevileOperater.desc();
					setResource.add(authMoudle + "," + operater + "," + operaterDesc);
					res = new AppResource();
					res.setResourceName(authMoudle);
					res.setResourceDes(operaterDesc);
					res.setOperation(operater);
					listResource.add(res);
				}
			}

		}
		return listResource;

	}
}