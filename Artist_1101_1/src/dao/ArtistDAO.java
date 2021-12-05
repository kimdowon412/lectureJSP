package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.ArtistVO;
import vo.PointVO;

public class ArtistDAO {
	
	public int insertArtist(ArtistVO vo) {
		int n = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_artist_201905 values (?,?,?,?,?,?)";
		
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	// 참가자 목록 조회
	public ArrayList<ArtistVO> selectArtist() {
		ArrayList<ArtistVO> artistList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_artist_201905 order by artist_id";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ArtistVO vo = new ArtistVO();
				
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setArtist_gender(rs.getString("artist_gender"));
				vo.setTalent(rs.getString("talent"));
				vo.setAgency(rs.getString("agency"));
				
				artistList.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return artistList;
	}
	
	// 멘토 점수 조회
	public ArrayList<PointVO> selectPoint() {
		ArrayList<PointVO> pointList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.artist_id, artist_name, artist_birth, point, mento_name"
				+ "	from TBL_ARTIST_201905 a, TBL_MENTO_201905 b, TBL_POINT_201905 c "
				+ "	where a.artist_id = c.artist_id and b.mento_id = c.mento_id";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PointVO vo = new PointVO();
				
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setArtist_birth(rs.getString("artist_birth"));
				vo.setGrade("");
				vo.setMento_name(rs.getString("mento_name"));
				
				Integer point = rs.getInt("point");
				String grade = "";
				
				switch (point/10) {
					case 10:
					case 9: grade = "A"; break;
					case 8: grade = "B"; break;
					case 7: grade = "C"; break;
					case 6: grade = "D"; break;
					default: grade = "E"; break;
				}
				vo.setPoint(point);
				vo.setGrade(grade);
				
				pointList.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return pointList;
	}
	
	// 참가자 등수 조회
	public ArrayList<PointVO> selectRank() {
		ArrayList<PointVO> rankList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select artist_id, artist_name, p_sum, p_avg, rownum as rk from ("
				+ "select a.artist_id, artist_name, sum(point) as p_sum, round(avg(point), 2) p_avg"
				+ "	from tbl_artist_201905 a, TBL_POINT_201905 b "
				+ "	where a.artist_id = b.artist_id"
				+ "	group by a.artist_id, artist_name"
				+ "	order by sum(point) desc"
				+ ")";
		
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PointVO vo = new PointVO();
				vo.setArtist_id(rs.getString("artist_id"));
				vo.setArtist_name(rs.getString("artist_name"));
				vo.setPoint(rs.getInt("p_sum"));
				vo.setAverage(rs.getFloat("p_avg"));
				vo.setRank(rs.getInt("rk"));
				
				rankList.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return rankList;
	}
	
}












