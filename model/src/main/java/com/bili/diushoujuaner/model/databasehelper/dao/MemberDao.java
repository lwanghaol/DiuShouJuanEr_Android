package com.bili.diushoujuaner.model.databasehelper.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.bili.diushoujuaner.model.databasehelper.dao.Member;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEMBER".
*/
public class MemberDao extends AbstractDao<Member, Long> {

    public static final String TABLENAME = "MEMBER";

    /**
     * Properties of entity Member.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PartyNo = new Property(1, long.class, "partyNo", false, "PARTY_NO");
        public final static Property UserNo = new Property(2, long.class, "userNo", false, "USER_NO");
        public final static Property NickName = new Property(3, String.class, "nickName", false, "NICK_NAME");
        public final static Property AddTime = new Property(4, java.util.Date.class, "addTime", false, "ADD_TIME");
        public final static Property Type = new Property(5, int.class, "type", false, "TYPE");
    };


    public MemberDao(DaoConfig config) {
        super(config);
    }
    
    public MemberDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEMBER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PARTY_NO\" INTEGER NOT NULL ," + // 1: partyNo
                "\"USER_NO\" INTEGER NOT NULL ," + // 2: userNo
                "\"NICK_NAME\" TEXT NOT NULL ," + // 3: nickName
                "\"ADD_TIME\" INTEGER NOT NULL ," + // 4: addTime
                "\"TYPE\" INTEGER NOT NULL );"); // 5: type
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_MEMBER_PARTY_NO ON MEMBER" +
                " (\"PARTY_NO\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEMBER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Member entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPartyNo());
        stmt.bindLong(3, entity.getUserNo());
        stmt.bindString(4, entity.getNickName());
        stmt.bindLong(5, entity.getAddTime().getTime());
        stmt.bindLong(6, entity.getType());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Member readEntity(Cursor cursor, int offset) {
        Member entity = new Member( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // partyNo
            cursor.getLong(offset + 2), // userNo
            cursor.getString(offset + 3), // nickName
            new java.util.Date(cursor.getLong(offset + 4)), // addTime
            cursor.getInt(offset + 5) // type
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Member entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPartyNo(cursor.getLong(offset + 1));
        entity.setUserNo(cursor.getLong(offset + 2));
        entity.setNickName(cursor.getString(offset + 3));
        entity.setAddTime(new java.util.Date(cursor.getLong(offset + 4)));
        entity.setType(cursor.getInt(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Member entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Member entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
