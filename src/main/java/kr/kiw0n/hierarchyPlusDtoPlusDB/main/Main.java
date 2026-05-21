package kr.kiw0n.hierarchyPlusDtoPlusDB.main;

import kr.kiw0n.hierarchyPlusDtoPlusDB.db.DB;
import kr.kiw0n.hierarchyPlusDtoPlusDB.controller.UserController;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try(Connection conn =
                DB.getConnection()) {

            System.out.println("DB 연결 성공");
        } catch (Exception e){
            e.printStackTrace();
        }

        UserController controller = new UserController();
        controller.start();
    }
}