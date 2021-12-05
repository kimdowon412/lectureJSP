package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ArtistVO;
import vo.PointVO;

public class ArtistDAO {

    public int insertArtist(ArtistVO vo) {
        
        int n = 0;
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into tbl_artist_201905 values(?,?,?,?,?,?)";
        
        conn = JdbcUtil.getConnection();
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getArtist_id());
            pstmt.setString(2, vo.getArtist_name());
            pstmt.setString(3, vo.getArtist_birth());
            pstmt.setString(4, vo.getArtist_gender());
            pstmt.setString(5, vo.getTalent());
            pstmt.setString(6, vo.getAgency());
            
            n = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return n;
    }

    public ArrayList<ArtistVO> selectArtist() {
        
        // DB에서 arraylist 형식으로 aritst 목록 가져오기
        ArrayList<ArtistVO> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String sql = "select * from tbl_artist_201905 order by artist_id";
        
        conn = JdbcUtil.getConnection();
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                ArtistVO vo = new ArtistVO();

                // birth 바꿔주기
                String birth = rs.getString("artist_birth");
                String printBirth = birth.substring(0,4) + "년" + birth.substring(4,6) + "월"+ birth.substring(6,8) + "일";
                
                // gender 바꿔주기
                String gender = rs.getString("artist_gender"); // M남자 F여자
                String printGender;
                if(gender.equals("M")) {
                    printGender = "남성";
                }else {
                    printGender = "여자";
                }
                
                // talent 바꿔주기
                String talent = rs.getString("talent");
                String printTalent;
                
                switch(talent) {
                case "1" : printTalent = "보컬"; break;
                case "2" : printTalent = "댄스"; break;
                case "3" : printTalent = "랩"; break;
                default : printTalent = "오류"; break;
                }
                
                vo.setArtist_id(rs.getString("artist_id"));
                vo.setArtist_name(rs.getString("artist_name"));
                vo.setArtist_birth(printBirth);
                vo.setArtist_gender(printGender);
                vo.setTalent(printTalent);
                vo.setAgency(rs.getString("agency"));
                
                list.add(vo);
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

	public ArrayList<PointVO> selectPoint() {
		ArrayList<PointVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select a.artist_id, artist_name, artist_birth, point, mento_name from tbl_artist_201905 a, tbl_mento_201905 m, tbl_point_201905 p where a.artist_id = p.artist_id and m.mento_id= p.mento_id ";
		conn = JdbcUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PointVO vo = new PointVO();
				
				  String birth = rs.getString("artist_birth");
	                String printBirth = birth.substring(0,4) + "년" + birth.substring(4,6) + "월"+ birth.substring(6,8) + "일";
	            
	            int point = rs.getInt("point");
	           String  printGrade;
	            switch(point/10) {
	            	case 10 : printGrade = "A"; break;
	            	case 9 : printGrade = "A"; break;
	            	case 8 : printGrade = "B"; break;
	            	case 7 : printGrade = "C"; break;
	            	case 6 : printGrade = "D"; break;
	            	default : printGrade = "F"; break;
	            }
				vo.setArtistId(rs.getString("artist_id"));
				vo.setArtistName(rs.getString("artist_name"));
				vo.setBirth(birth);
				vo.setPoint(point);
				vo.setGrade(printGrade);
				System.out.println(printGrade);
				vo.setMentoName(rs.getString("mento_name"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<PointVO> selectRank() {
		ArrayList<PointVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select a.artist_id, artist_name, sum(point) as p_sum, round(avg(point),2) as p_avg, rank() over(order by sum(point) desc) as rk from tbl_artist_201905 a, tbl_point_201905 p where a.artist_id = p.artist_id group by a.artist_id, artist_name order by sum(point) desc";
		conn = JdbcUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PointVO vo  = new PointVO();
						
				vo.setArtistId(rs.getString("artist_id"));
				vo.setArtistName(rs.getString("artist_name"));
				vo.setPoint(rs.getInt("p_sum"));
				vo.setAverage(rs.getFloat("p_avg"));
				vo.setRank(rs.getInt("rk"));
				System.out.println(rs.getInt("rk"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
    
}