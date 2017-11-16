package net.brsc.bean.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;//JPA
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 地区持久化类
 * @author sysmaster
 *
 */
@Entity  //说明该类是实体类
@Table(name="T_AREA") //与数据库T_AREA进行绑定  一一对应

public class AreaPO 
{
	//区域编号
	private Integer areaNO;
	
	//区域名称
	private String  areaName;
	
	//所拥有的子区域
	private Set<AreaPO> areas; //
	
	//对应的上级区域
//	private AreaPO parea; //
	//	private AreaPO pArea; //主要写法要符合get,set方法
	

	public AreaPO()
	{
		areas = new HashSet<AreaPO>();//
	}
	
	public AreaPO(Integer areaNO, String areaName) 
	{
		this();//确保能调用public AreaPO()方法
		this.areaNO = areaNO;
		this.areaName = areaName;
	}
	
	//注解文件一般写在属性和get方法前面，一般都写在get方法前面，
	//但是整个工程必须统一,否则会报错
	
	@Id   //主键映射
	@GeneratedValue  //自动编号  musql中有，oracle中没有支持,但是这里是hibernte实现的
	public Integer getAreaNO() {
		return areaNO;
	}
	public void setAreaNO(Integer areaNO) {
		this.areaNO = areaNO;
	}
	
	
	@Column(length=100,nullable=false)
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
//	public void setParea(AreaPO parea) {
//		this.parea = parea;
//	}
//	//上级
//	@OneToMany(mappedBy="areas",cascade=CascadeType.PERSIST)
//    public AreaPO getParea() {
//		return parea;
//	}
	
    //下级
    @ManyToOne(targetEntity=AreaPO.class,cascade={CascadeType.PERSIST,CascadeType.REFRESH})
    
    public Set<AreaPO> getAreas() {
		return areas;
	}
     public void setAreas(Set<AreaPO> areas) {
		this.areas = areas;
	}
	
	
	
	
}
