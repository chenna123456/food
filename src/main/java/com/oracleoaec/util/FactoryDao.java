package com.oracleoaec.util;

import com.oracleoaec.dao.ArticleCollectionDao;
import com.oracleoaec.dao.ArticleDao;
import com.oracleoaec.dao.CombinationfoodDao;
import com.oracleoaec.dao.ComplaintDao;
import com.oracleoaec.dao.DiningCarDao;
import com.oracleoaec.dao.ExchangegiftDao;
import com.oracleoaec.dao.FixedfoodDao;
import com.oracleoaec.dao.GiftCarDao;
import com.oracleoaec.dao.LeavemessageDao;
import com.oracleoaec.dao.NavigationDao;
import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.dao.OrderFoodDao;
import com.oracleoaec.dao.OrderListInfoDao;
import com.oracleoaec.dao.SetMealDao;
import com.oracleoaec.dao.VipDao;
import com.oracleoaec.dao.VipcommentDao;
import com.oracleoaec.daoImp.ArticleCollectionDaoImp;
import com.oracleoaec.daoImp.ArticleDaoImp;
import com.oracleoaec.daoImp.CombinationfoodDaoImp;
import com.oracleoaec.daoImp.ComplaintDaoImp;
import com.oracleoaec.daoImp.DiningCarDaoImp;
import com.oracleoaec.daoImp.ExchangegiftDaoImp;
import com.oracleoaec.daoImp.FixedfoodDaoImp;
import com.oracleoaec.daoImp.GiftCarDaoImp;
import com.oracleoaec.daoImp.LeavemessageDaoImp;
import com.oracleoaec.daoImp.NavigationDaoImp;
import com.oracleoaec.daoImp.OptionalfoodDaoImp;
import com.oracleoaec.daoImp.OrderFoodDaoImp;
import com.oracleoaec.daoImp.OrderListInfoDaoImp;
import com.oracleoaec.daoImp.SetMealDaoImp;
import com.oracleoaec.daoImp.VipDaoImp;
import com.oracleoaec.daoImp.VipcommentDaoImp;

/**
 * Dao层工厂类，用于实现接口实例化
 * 
 * @author 陈娜
 *
 */
public class FactoryDao {

	public ArticleDao getArticleDao() {
		return new ArticleDaoImp();
	}

	public CombinationfoodDao getCombinationfoodDao() {
		return new CombinationfoodDaoImp();
	}

	public ComplaintDao getComplaintDao() {
		return new ComplaintDaoImp();
	}

	public DiningCarDao getDiningCarDao() {
		return new DiningCarDaoImp();
	}

	public ExchangegiftDao getExchangegiftDao() {
		return new ExchangegiftDaoImp();
	}

	public FixedfoodDao getFixedfoodDao() {
		return new FixedfoodDaoImp();
	}

	public GiftCarDao getGiftCarDao() {
		return new GiftCarDaoImp();
	}

	public LeavemessageDao getLeavemessageDao() {
		return new LeavemessageDaoImp();
	}

	public NavigationDao getNavigationDao() {
		return new NavigationDaoImp();
	}

	public OptionalfoodDao getOptionalfoodDao() {
		return new OptionalfoodDaoImp();
	}

	public OrderFoodDao getOrderFoodDao() {
		return new OrderFoodDaoImp();
	}

	public OrderListInfoDao getOrderListInfoDao() {
		return new OrderListInfoDaoImp();
	}

	public SetMealDao getSetMealDao() {
		return new SetMealDaoImp();
	}

	public VipcommentDao getVipcommentDao() {
		return new VipcommentDaoImp();
	}

	public VipDao getVipDao() {
		return new VipDaoImp();
	}
	public ArticleCollectionDao getArticleCollectionDao(){
		return new ArticleCollectionDaoImp();
	}
}
