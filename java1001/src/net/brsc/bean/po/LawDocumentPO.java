/**
 * 
 */
package net.brsc.bean.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 执法文书实体类
 * @author 明勇
 *
 */
@Entity
@Table(name="T_LAW_DOCUMENT")
public class LawDocumentPO extends DocumentPO {

    
	private String lawDocuNO;
	private Set<DocumentPO> docs;
	
	
	
	public LawDocumentPO() {
		docs = new HashSet<DocumentPO>();
		
	}
	
	public LawDocumentPO(String lawDocuNO, Set<DocumentPO> docs) {
		this();
		this.lawDocuNO = lawDocuNO;
		this.docs = docs;
	}
	
	public String getLawDocuNO() {
		return lawDocuNO;
	}
	public void setLawDocuNO(String lawDocuNO) {
		this.lawDocuNO = lawDocuNO;
	}
	
	@ManyToOne(targetEntity=DocumentPO.class,cascade={CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="docNO")
	public Set<DocumentPO> getDocs() {
		return docs;
	}
	public void setDocs(Set<DocumentPO> docs) {
		this.docs = docs;
	}
	
}
