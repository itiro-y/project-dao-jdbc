package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement(
                    "INSERT INTO department " +
                        "(Name) " +
                        "VALUES " +
                        "(?)",
                        Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, obj.getName());

            int affectedRows = ps.executeUpdate();

            if(affectedRows > 0){
                ResultSet rs = ps.getGeneratedKeys();

                if(rs.next()){
                    obj.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);

            } else{
                throw new DbException("Error. Could not insert department");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(
                    "SELECT * " +
                        "FROM department " +
                        "WHERE Id = ?"
            );
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally{
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department obj = new Department();
        obj.setId(rs.getInt(1));
        obj.setName(rs.getString(2));
        return obj;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
