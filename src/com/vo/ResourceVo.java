package com.vo;

import com.po.Resource;

public class ResourceVo extends Resource{
	/**
	 * 资源id的上级id
	 */
	private String resourcesuperior;

	public String getResourcesuperior() {
		return resourcesuperior;
	}

	public void setResourcesuperior(String resourcesuperior) {
		this.resourcesuperior = resourcesuperior;
	}
}
