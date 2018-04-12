package br.com.flexvision.befd.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Widget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column
	private String height;

	@Column
	private String classCol;

	@Column
	private String caption;

	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private List<ItemFilter> optionGraph;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getClassCol() {
		return classCol;
	}

	public void setClassCol(String classCol) {
		this.classCol = classCol;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public List<ItemFilter> getOptionGraph() {
		return optionGraph;
	}

	public void setOptionGraph(List<ItemFilter> optionGraph) {
		this.optionGraph = optionGraph;
	}
	
}