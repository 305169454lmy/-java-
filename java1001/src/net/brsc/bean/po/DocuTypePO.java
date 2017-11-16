/**
 * 
 */
package net.brsc.bean.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文书类型实体类
 * @author 明勇
 *
 */
@Entity
@Table(name="T_DOC_TYPE")
public class DocuTypePO {
      
	//类型编号
	 private Integer typeNO;
	 //类型名称
	 private String typeName;
	 //
	 private String memo;
	 
	 

	@Id
	 @GeneratedValue
	public Integer getTypeNO() {
		return typeNO;
	}
	public void setTypeNO(Integer typeNO) {
		this.typeNO = typeNO;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 
	 
}
