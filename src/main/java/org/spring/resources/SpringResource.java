package org.spring.resources;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class SpringResource implements ApplicationContextAware{
	
	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	
	/**
     * 通过classpath前缀获取Resource
     *
     * @throws IOException
     */
    public void getClassPathResouce() throws IOException {
        Resource resource = context.getResource("classpath:test-resources.txt");
        System.out.println("ResourceLoader(classpath) filename: " + resource.getFilename());
        System.out.println("ResourceLoader(classpath) size: " + resource.contentLength());
    }
    
    /**
     * 通过file前缀获取Resource
     *
     * @throws IOException
     */
    public void getFileResouce() throws IOException {
         
        Resource resource = context.getResource("file:E:\\eclipse\\workspace\\Spring_Resources\\src\\main\\resource\\test-resources.txt");
        System.out.println("ResourceLoader(file) filename: " + resource.getFilename());
        System.out.println("ResourceLoader(file) size: " + resource.contentLength());
    }
    
    /**
     * 通过url前缀获取Resource
     *
     * @throws IOException
     */
    public void getUrlResouce() throws IOException {
         
        Resource resource = context.getResource("url:http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/");
        System.out.println("ResourceLoader(url) filename: " + resource.getFilename());
        System.out.println("ResourceLoader(url) size: " + resource.contentLength());
         
    }
    
    
    /**
     * 无前缀获取Resource
     *
     * 跟application context有关，本代码中的application context是根据classpath获取的，所以该方法中也是根据classpath前缀获取的Resource
     *
     * @throws IOException
     */
    public void getResouce() throws IOException {
         
        Resource resource = context.getResource("test-resources.txt");
        System.out.println("ResourceLoader(none) filename: " + resource.getFilename());
        System.out.println("ResourceLoader(none) size: " + resource.contentLength());
         
    }
    
    
}
