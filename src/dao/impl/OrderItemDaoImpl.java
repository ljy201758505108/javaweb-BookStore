package dao.impl;

import dao.OrderItemDao;
import org.apache.commons.dbutils.QueryRunner;
import utils.JdbcUtils;

public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public void delete(String orderItemid) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from orderitem where id=?";
            runner.update(sql, orderItemid);
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
