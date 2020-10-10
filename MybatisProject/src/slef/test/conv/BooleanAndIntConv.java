package slef.test.conv;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
//BaseHandler<java 类型>
//ps：PreparedStatement 对象
//i：PreparedStatement 对象操作参数位置
//parameter：java值
//JdbcType：Jdbc操作的数据库类型
public class BooleanAndIntConv extends BaseTypeHandler<Boolean> {
    //java->db
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		if(parameter)
		{
			ps.setInt(i, 1);
		}
		else
		{
			ps.setInt(i, 0);
		}
	}
	//db->java
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		
		int sexNum =rs.getInt(columnName);
		
		return sexNum == 1?true:false;
		

	}
	//db->java
	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	int sexNum =rs.getInt(columnIndex);
		
		return sexNum == 1?true:false;
		
	}
	//db->java
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	int sexNum =cs.getInt(columnIndex);
		
		return sexNum == 1?true:false;
	}

	
	
}
