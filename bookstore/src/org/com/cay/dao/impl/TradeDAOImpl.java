package org.com.cay.dao.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.com.cay.dao.ITradeDAO;
import org.com.cay.entity.Trade;


public class TradeDAOImpl extends BaseDAO<Trade> implements ITradeDAO {

	@Override
	public void insert(Trade trade) {
		String sql = "INSERT INTO trade (userid, tradetime) VALUES " +
				"(?, ?)";
		long tradeId = insert(sql, trade.getUserId(), trade.getTradeTime());
		trade.setTradeId((int)tradeId);
	}

	@Override
	public Set<Trade> getTradesWithUserId(Integer userId) {
		String sql = "SELECT tradeId, userId, tradeTime FROM trade " +
				"WHERE userId = ? ORDER BY tradeTime DESC";
		return new LinkedHashSet<Trade>(queryForList(sql, userId));
	}

}
