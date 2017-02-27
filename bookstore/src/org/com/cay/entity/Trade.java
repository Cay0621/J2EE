package org.com.cay.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 交易实体类
 */
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tradeId;// 交易ID
	private Date tradeTime;// 交易时间

	private Integer userId;// 交易的用户ID

	// 交易详情
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime + ", userId=" + userId + "]";
	}
}
