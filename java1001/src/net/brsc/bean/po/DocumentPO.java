package net.brsc.bean.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文书实体类
 * @author 明勇
 *
 */
@Entity
@Table(name="T_DOC_INFO")
@Inheritance()
public class DocumentPO {
	//文书编号
   private Integer docNO;
   //文书标题
   private String title;
   //文书内容
   private String content;
   
   private Set<DocuTypePO> types;  //一个类型包含多种文书
    
   
 public DocumentPO() {
	 
	 types = new HashSet<DocuTypePO>();//实例化
	
}
 
 
public DocumentPO(Integer docNO, String title, String content, Set<DocuTypePO> types) {
	this();
	this.docNO = docNO;
	this.title = title;
	this.content = content;
	this.types = types;
}


@Id
 @GeneratedValue
public Integer getDocNO() {
	return docNO;
}
public void setDocNO(Integer docNO) {
	this.docNO = docNO;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Lob
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

@ManyToOne(targetEntity=DocuTypePO.class,cascade={CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name="typeNO")
public Set<DocuTypePO> getTypes() {
	return types;
}
public void setTypes(Set<DocuTypePO> types) {
	this.types = types;
}

}
