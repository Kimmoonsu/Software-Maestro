package letter.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import letter.abst.dao.abDAO;


@SuppressWarnings("unchecked")
@Repository("UserDao")
public class UserDao extends abDAO{
	public int selectLetterPK() {
		return (int)selectOne("sample.selectLetterPK");
	}
	public List<Map<String, Object>> selectMemberList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectMemberList", commandMap);
	}
	public List<Map<String, Object>> selectLetterList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectLetterList", commandMap);
	}
	public List<Map<String, Object>> selectAccessList(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectAccessList", commandMap);
	}
	public List<Map<String, Object>> selectFindLetter(Map<String, Object> commandMap) {
		return (List<Map<String,Object>>)selectList("sample.selectFindLetter", commandMap);
	}
	
	public String selectFindRegister(String to_id) {
		return (String)selectOne("sample.selectFindRegister", to_id);
	}
	public void insertMember(Map<String, Object> map) {
		insert("sample.insertMember", map);
	}
	public void accessMember(Map<String, Object> map) {
		insert("sample.accessMember", map);
	}
	public void insertLetter(Map<String, Object> map) {
		insert("sample.insertLetter", map);
	}

	public void deleteMember(Map<String, Object> map) {
		delete("sample.deleteMember",map);
	}
	
	public void deleteLetter(Map<String, Object> map) {
		delete("sample.deleteLetter",map);
	}
	
	public void deleteAccess(Map<String, Object> map) {
		delete("sample.deleteAccess",map);
	}

	public void updateLetterState(Map<String, Object> map) {
		update("sample.updateLetterState", map);
	}

	public void closeUser(Map<String, Object> map) {
		update("sample.closeUser", map);
	}
}