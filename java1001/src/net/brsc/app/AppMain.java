package net.brsc.app;

import net.brsc.bean.po.AreaPO;
import net.brsc.bean.po.DocuTypePO;
import net.brsc.bean.po.DocumentPO;
import net.brsc.bean.po.LawDocumentPO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppMain {

	public static void main(String[] args) 
	{
		SessionFactory sessionFactory = null;
		
		try 
		{  
			/**Hibernate4取得SessionFactory的方法 */  
			//创建cfg对象读取配置文件
			Configuration cfg = new Configuration().configure("config/hibernate/hibernate.xml");
			
            //指定映射的类AreaPO			
			cfg.addAnnotatedClass(AreaPO.class);
			cfg.addAnnotatedClass(DocumentPO.class);
			cfg.addAnnotatedClass(DocuTypePO.class);
			cfg.addAnnotatedClass(LawDocumentPO.class);
			
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
            
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
            
        } 
		catch (Throwable e) 
		{  
            throw new ExceptionInInitializerError(e);  
        }  
    } 
}
