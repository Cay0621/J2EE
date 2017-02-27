package org.com.cay.dao;

import java.util.Collection;
import java.util.Set;

import org.com.cay.entity.TradeItem;

public interface ITradeItemDAO {

	/**
	 * 批量保存 TradeItem 对象
	 * 
	 * @param items
	 */
	public abstract void batchSave(Collection<TradeItem> items);

	/**
	 * 根据 tradeId 获取和其关联的 TradeItem 的集合
	 * 
	 * @param tradeId
	 * @return
	 */
	public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}
