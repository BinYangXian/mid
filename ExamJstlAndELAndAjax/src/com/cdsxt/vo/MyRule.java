package com.cdsxt.vo;

public class MyRule {
/*	<th align="center"  >编码</th>
	<th align="center"  >弹性计算规则</th>	
	<th align="center"  >摘要</th>
	<th align="center"  >参数</th>
	<th align="center"  >说明</th>*/
	private int id;
	private String rule;
	private String summary;
	private String param;
	private String info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public MyRule(int id, String rule, String summary, String param, String info) {
		super();
		this.id = id;
		this.rule = rule;
		this.summary = summary;
		this.param = param;
		this.info = info;
	}
	@Override
	public String toString() {
		return "MyRule [id=" + id + ", rule=" + rule + ", summary=" + summary
				+ ", param=" + param + ", info=" + info + "]";
	}
	
}
