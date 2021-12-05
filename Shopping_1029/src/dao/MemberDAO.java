package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.MemberVO;
import vo.MoneyVO;

public class MemberDAO {
	// �쉶�썝�젙蹂� �뀒�씠釉붿뿉�꽌 �쉶�썝�벑濡앸쾲�샇 max + 1 媛믪쓣 媛�吏�怨� �삤湲�
	public int getMaxCustNo() {
		int custno = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(custno)+1 as max_no from member_tbl_02";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				custno = rs.getInt("max_no");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return custno;
	}

	public int insertMember(MemberVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member_tbl_02(custno, custname, phone, address,"
				+ "joindate, grade, city) values(?,?,?,?,?,?,?)";
		
		//DB연결 -> SQL문 실행 -> DB 연결해제
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setDate(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7,vo.getCity());
			
			n = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		return n;
	}

	public ArrayList<MemberVO> getMemberList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02 order by coustno";
		
		ArrayList<MemberVO> list = new ArrayList<>();
	
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
//				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
				String grade = rs.getString("grade");
				if(grade.equalsIgnoreCase("A"))
					grade = "VIP";
				else if(grade.equalsIgnoreCase("B"))
					grade = "일반";
				else if(grade.equalsIgnoreCase("C"))
					grade = "직원";
				else
					grade = "오류";
				vo.setGrade(grade);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public ArrayList<MoneyVO> getMoneyList() {
		// DB연결 (Connection) -> SQL문 실행(PreparedStatement, ResultSet) -> DB연결 해제
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.custno, a.custname, a.grade, sum(b.price) as sum_price" + "from member_tbl_02 a, money_tbl_02 b" + "where a.custno = b.custno" + "group by a.custno, a.custname, a.grade" + "order by sum_price desc";
		ArrayList<MoneyVO> list = new ArrayList<>();
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			while(rs.next()) {
				MoneyVO vo = new MoneyVO();
				
				//rs의데이터 -> vo 객체에 저장하기
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setPrice(rs.getInt("sum_price"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	finally {
			JdbcUtil.close(conn, pstmt);
		}
		return list;
	}

	public MemberVO getMemberData(int custno) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
}















