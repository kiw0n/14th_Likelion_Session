// DB 관련 클래스가 들어있는 패키지 선언
package kr.kiw0n.hierarchyPlusDtoPlusDB.db;

// 데이터베이스 연결 객체(Connection)를 사용하기 위한 import
import java.sql.Connection;

// DB 연결을 생성하는 DriverManager 사용
import java.sql.DriverManager;

// SQL 예외 처리(SQLException)를 사용하기 위한 import
import java.sql.SQLException;

// 데이터베이스 연결을 담당하는 클래스
public class DB {

    // DB 주소(URL)를 상수(final)로 선언
    // localhost : 내 컴퓨터 서버
    // 3306 : MySQL 기본 포트 번호
    // likelion : 연결할 데이터베이스 이름
    private static final String URL =
            "jdbc:mysql://localhost:3306/likelion";

    // DB 로그인 아이디
    private static final String USER = "root";

    // DB 로그인 비밀번호
    // 현재 비밀번호가 없어서 빈 문자열("") 사용
    private static final String PASSWORD = "";

    // 데이터베이스 연결(Connection)을 반환하는 메서드
    public static Connection getConnection() {

        // 예외가 발생할 수 있으므로 try-catch 사용
        try {

            // DriverManager를 이용해 DB 연결 생성 후 반환
            // URL : DB 주소
            // USER : 사용자 이름
            // PASSWORD : 비밀번호
            return DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

        } catch (SQLException e) {

            // DB 연결 실패 시 RuntimeException 발생
            // 원래 발생한 예외(e)도 함께 전달해서 원인 확인 가능
            throw new RuntimeException("DB 연결 실패", e);
        }
    }
}