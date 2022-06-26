package database;

public class Transaction {
    private DAO dao;

    public Transaction(DAO dao) {
        this.dao = dao;
    }

    public boolean insertSignUp(int stdId, int scId, int sbjId, String grade) {
        return new InsertSignUp().insert(dao.con, stdId, scId, sbjId, grade);
    }

    public boolean insertSubject(int sbjId, String sbjName, int scId) {
        return new InsertSubject().insert(dao.con, sbjId, sbjName, scId);
    }

    public boolean updateSignUp(int stdId, int newScId, int newSbjId, int oldSbjId) {
        return new UpdateSignUp().update(dao.con, stdId, newScId, newSbjId, oldSbjId );
    }

    public String showDistributionAttendance(int sbjId, int scId) {
        return new ShowDistributionAttendance().show(dao.con, sbjId, scId);
    }

    public String showSignUp(int stdId) {
        return new ShowSignUp().show(dao.con, stdId);
    }

    public String showSubject() {
        return new ShowSubject().show(dao.con);
    }

    public String showSubjectAttendance(int sbjId) {
        return new ShowSubjectAttendance().show(dao.con, sbjId);
    }
}
