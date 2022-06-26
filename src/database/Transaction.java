package database;

public class Transaction {
    private DAO dao;

    public Transaction(DAO dao) {
        this.dao = dao;
    }

    public void insertSignUp(int stdId, int scId, int sbjId, String grade) {
        new InsertSignUp().insert(dao.con, stdId, scId, sbjId, grade);
    }

    public void insertSubject(int sbjId, String sbjName, int scId) {
        new InsertSubject().insert(dao.con, sbjId, sbjName, scId);
    }

    public void showDistributionAttendance(int sbjId, int scId) {
        new ShowDistributionAttendance().show(dao.con, sbjId, scId);
    }

    public void showSignUp(int stdId) {
        new ShowSignUp().show(dao.con, stdId);
    }

    public void showSubject() {
        new ShowSubject().show(dao.con);
    }

    public void showSubjectAttendance(int sbjId) {
        new ShowSubjectAttendance().show(dao.con, sbjId);
    }

    public void updateSignUp(int stdId, int newScId, int newSbjId, int oldSbjId) {
        new UpdateSignUp().update(dao.con, stdId, newScId, newSbjId, oldSbjId );
    }
}
