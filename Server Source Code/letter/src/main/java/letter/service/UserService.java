package letter.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import letter.dao.UserDao;

@Service("UserService")
public class UserService {

	@Resource(name = "UserDao")
	private UserDao dao;

	public Object good() {
		// TODO Auto-generated method stub
		return "Letter";
	}
	// PK 출력
	public int selectLetterPK() throws Exception {
		return dao.selectLetterPK();
	}
	// member 전체 출력
	public List<Map<String, Object>> selectMemberList(Map<String, Object> Map) throws Exception {
		return dao.selectMemberList(Map);
	}
	
	// 접속자 전체 출력
		public List<Map<String, Object>> selectAccessList(Map<String, Object> Map) throws Exception {
			return dao.selectAccessList(Map);
		}

	// find letter
	public List<Map<String, Object>> selectFindLetter(Map<String, Object> Map) throws Exception {
		return dao.selectFindLetter(Map);
	}

	// find register_id
	public String selectFindRegister(String to_id) throws Exception {
		return dao.selectFindRegister(to_id);
	}

	// member 한명 insert
	public void insertMember(Map<String, Object> map) {
		dao.insertMember(map);
	}
	
	// access member insert
	public void accessMember(Map<String, Object> map) {
		dao.accessMember(map);
	}
		
	// letter insert
	public void insertLetter(Map<String, Object> map) {
		dao.insertLetter(map);
	}

	// member 한명 delete
	public void deleteMember(Map<String, Object> map) {
		dao.deleteMember(map);
	}

	// letter delete
	public void deleteLetter(Map<String, Object> map) {
		dao.deleteLetter(map);
	}
	
	// access mumber delete
	public void deleteAccess(Map<String, Object> map) {
		dao.deleteAccess(map);
	}

	// letter 전체 출력
	public List<Map<String, Object>> selectLetterList(Map<String, Object> Map) throws Exception {
		return dao.selectLetterList(Map);
	}

	// update letter read state 
	public void updateLetterState(Map<String, Object> map) {
		dao.updateLetterState(map);
	}
	
	public void closeUser(Map<String, Object> map) {
		dao.closeUser(map);
	}
}