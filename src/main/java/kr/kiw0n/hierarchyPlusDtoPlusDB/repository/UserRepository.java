package kr.kiw0n.hierarchyPlusDtoPlusDB.repository;

import kr.kiw0n.hierarchyPlusDtoPlusDB.domain.User;
import kr.kiw0n.hierarchyPlusDtoPlusDB.db.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void save(User user){
        String sql =
                "INSERT INTO user(name, age, grade, gender) VALUES(?, ?, ?, ?)";

        try (
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                )
        {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setInt(3, user.getGrade());
            ps.setString(4, user.getGender());

            ps.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                ){
            while (rs.next()){
                users.add(new User(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("grade"),
                        rs.getString("gender")
                ));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return  users;
    }

    public User findByName(String name){
        String sql = "SELECT * FROM user WHERE name = ?";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
                ){
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("grade"),
                        rs.getString("gender")
                );
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean update(String name, User user) {

        String sql =
                "UPDATE user SET age = ?, grade = ?, gender = ? WHERE name = ?";

        try (
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, user.getAge());
            ps.setInt(2, user.getGrade());
            ps.setString(3, user.getGender());
            ps.setString(4, name);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean delete(String name) {

        String sql =
                "DELETE FROM user WHERE name = ?";

        try (
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, name);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}