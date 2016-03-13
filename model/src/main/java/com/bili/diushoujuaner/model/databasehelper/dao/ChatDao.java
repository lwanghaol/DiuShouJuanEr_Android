package com.bili.diushoujuaner.model.databasehelper.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.bili.diushoujuaner.model.databasehelper.dao.Chat;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHAT".
*/
public class ChatDao extends AbstractDao<Chat, Long> {

    public static final String TABLENAME = "CHAT";

    /**
     * Properties of entity Chat.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OwnerNo = new Property(1, long.class, "ownerNo", false, "OWNER_NO");
        public final static Property FromNo = new Property(2, long.class, "fromNo", false, "FROM_NO");
        public final static Property ToNo = new Property(3, long.class, "toNo", false, "TO_NO");
        public final static Property Content = new Property(4, String.class, "content", false, "CONTENT");
        public final static Property Time = new Property(5, java.util.Date.class, "time", false, "TIME");
        public final static Property MsgType = new Property(6, int.class, "msgType", false, "MSG_TYPE");
        public final static Property ConType = new Property(7, int.class, "conType", false, "CON_TYPE");
    };


    public ChatDao(DaoConfig config) {
        super(config);
    }
    
    public ChatDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHAT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"OWNER_NO\" INTEGER NOT NULL ," + // 1: ownerNo
                "\"FROM_NO\" INTEGER NOT NULL ," + // 2: fromNo
                "\"TO_NO\" INTEGER NOT NULL ," + // 3: toNo
                "\"CONTENT\" TEXT," + // 4: content
                "\"TIME\" INTEGER NOT NULL ," + // 5: time
                "\"MSG_TYPE\" INTEGER NOT NULL ," + // 6: msgType
                "\"CON_TYPE\" INTEGER NOT NULL );"); // 7: conType
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_CHAT_OWNER_NO ON CHAT" +
                " (\"OWNER_NO\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHAT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Chat entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getOwnerNo());
        stmt.bindLong(3, entity.getFromNo());
        stmt.bindLong(4, entity.getToNo());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
        stmt.bindLong(6, entity.getTime().getTime());
        stmt.bindLong(7, entity.getMsgType());
        stmt.bindLong(8, entity.getConType());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Chat readEntity(Cursor cursor, int offset) {
        Chat entity = new Chat( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // ownerNo
            cursor.getLong(offset + 2), // fromNo
            cursor.getLong(offset + 3), // toNo
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // content
            new java.util.Date(cursor.getLong(offset + 5)), // time
            cursor.getInt(offset + 6), // msgType
            cursor.getInt(offset + 7) // conType
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Chat entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOwnerNo(cursor.getLong(offset + 1));
        entity.setFromNo(cursor.getLong(offset + 2));
        entity.setToNo(cursor.getLong(offset + 3));
        entity.setContent(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTime(new java.util.Date(cursor.getLong(offset + 5)));
        entity.setMsgType(cursor.getInt(offset + 6));
        entity.setConType(cursor.getInt(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Chat entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Chat entity) {
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
