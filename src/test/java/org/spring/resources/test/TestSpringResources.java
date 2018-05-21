package org.spring.resources.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.resources.SpringResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;

@RunWith(BlockJUnit4ClassRunner.class)//默认执行类,可不写
public class TestSpringResources extends JunitTestBase{
	
	//构造器初始化spring配置文件
    public TestSpringResources() {
         
        super("classpath:spring_resources.xml");
         
    }
    
    /**
     * 测试UrlResource
     *
     * @throws IOException
     */
    @Test
    public void testUrlResources() throws IOException {
         
        UrlResource resource = new UrlResource("http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/");
        System.out.println("UrlResource filename:" + resource.getFilename());
        System.out.println("UrlResource size:" + resource.contentLength());
         
    }
    
    /**
     * 测试ClassPathResource
     *
     * @throws IOException
     */
    @Test
    public void testClassPathResource() throws IOException {
         
        ClassPathResource resource = new ClassPathResource("test-resources.txt");
        System.out.println("ClassPathResource filename:" + resource.getFilename());
        System.out.println("ClassPathResource size:" + resource.contentLength());
         
    }
    
    
    /**
     * 测试FileSystemResource
     *
     * @throws IOException
     */
    @Test
    public void testFileSystemResource() throws IOException {
         
        FileSystemResource resource = new FileSystemResource("E:\\eclipse\\workspace\\Spring_Resources\\src\\main\\resource\\test-resources.txt");
        System.out.println("FileSystemResource filename:" + resource.getFilename());
        System.out.println("FileSystemResource size:" + resource.contentLength());
         
    }
    
    
    /**
     * 测试InputStreamResource
     *
     * @throws IOException
     */
    @Test
    public void testInputStreamResource() throws IOException {
         
        InputStream is = new FileInputStream("E:\\eclipse\\workspace\\Spring_Resources\\src\\main\\resource\\test-resources.txt");
        InputStreamResource resource = new InputStreamResource(is);
        System.out.println("InputStreamResource filename:" + resource.getFilename());
        System.out.println("InputStreamResource size:" + resource.contentLength());
         
    }
    
    /**
     * 测试ByteArrayResource
     *
     * @throws IOException
     */
    @Test
    public void testByteArrayResource() throws IOException {
         
        ByteArrayResource resource = new ByteArrayResource("Test Resource".getBytes());
        System.out.println("ByteArrayResource filename:" + resource.getFilename());
        System.out.println("ByteArrayResource size:" + resource.contentLength());
         
    }
    
    /**
     * 测试ResourceLoader-classpath前缀
     *
     * @throws IOException
     */
    @Test
    public void testResourceLoaderClassPath() throws IOException {
         
        SpringResource springResource = (SpringResource) super.getBean("springResource");
        springResource.getClassPathResouce();
         
    }
    
    /**
     * 测试ResourceLoader-file前缀
     *
     * @throws IOException
     */
    @Test
    public void testResourceLoaderFile() throws IOException {
         
        SpringResource springResource = (SpringResource) super.getBean("springResource");
        springResource.getFileResouce();
         
    } 
    
    /**
     * 测试ResourceLoader-url前缀
     *
     * @throws IOException
     */
    @Test
    public void testResourceLoaderUrl() throws IOException {
         
        SpringResource springResource = (SpringResource) super.getBean("springResource");
        springResource.getUrlResouce();
         
    }
    
    
    /**
     * 测试ResourceLoader-无前缀
     *
     * @throws IOException
     */
    @Test
    public void testResourceLoader() throws IOException {
         
        SpringResource springResource = (SpringResource) super.getBean("springResource");
        springResource.getResouce();
         
    }

}
