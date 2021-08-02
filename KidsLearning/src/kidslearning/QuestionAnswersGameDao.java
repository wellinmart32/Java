/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidslearning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welli
 */
public class QuestionAnswersGameDao {
    
    public QuestionAnswersGame findOne(int questionAnswerGameId) {
        QuestionAnswersGame questionAnswerGame = null;
        Statement st = null;
        try {
            st = new DbConnection().getConnection().createStatement();
            if(st != null) {
                ResultSet rs;
                try {
                    rs = st.executeQuery("select * from QuestionAnswersGame where id = " + questionAnswerGameId);
                    if(rs.next()) {
                        questionAnswerGame = new QuestionAnswersGame();
                        questionAnswerGame.setId(rs.getInt(1));
                        questionAnswerGame.setGameId(rs.getInt(2));
                        questionAnswerGame.setQuestion(rs.getString(3));
                        questionAnswerGame.setAnswer1(rs.getString(4));
                        questionAnswerGame.setResult1(rs.getInt(5));
                        questionAnswerGame.setAnswer2(rs.getString(6));
                        questionAnswerGame.setResult2(rs.getInt(7));
                        questionAnswerGame.setAnswer3(rs.getString(8));
                        questionAnswerGame.setResult3(rs.getInt(9));
                        questionAnswerGame.setAnswer4(rs.getString(10));
                        questionAnswerGame.setResult4(rs.getInt(11));
                        questionAnswerGame.setAnswer5(rs.getString(12));
                        questionAnswerGame.setResult5(rs.getInt(13));
                        questionAnswerGame.setState(rs.getInt(14));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuestionAnswersGameDao.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAnswersGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionAnswerGame;
    }
    
    public int getTableSize() {
        Statement st = null;
        try {
            st = new DbConnection().getConnection().createStatement();
            if(st != null) {
                ResultSet rs;
                rs = st.executeQuery("select count(id) from QuestionAnswersGame");
                if(rs.next())
                    return rs.getInt(1);
                else
                    return 0;
            }else
                return 0;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionAnswersGameDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
