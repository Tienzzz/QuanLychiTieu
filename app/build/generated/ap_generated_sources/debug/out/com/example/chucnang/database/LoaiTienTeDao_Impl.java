package com.example.chucnang.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.chucnang.model.LoaiTienTe;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LoaiTienTeDao_Impl implements LoaiTienTeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LoaiTienTe> __insertionAdapterOfLoaiTienTe;

  private final EntityDeletionOrUpdateAdapter<LoaiTienTe> __updateAdapterOfLoaiTienTe;

  public LoaiTienTeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLoaiTienTe = new EntityInsertionAdapter<LoaiTienTe>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_money_type` (`money_id`,`money_name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiTienTe value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__updateAdapterOfLoaiTienTe = new EntityDeletionOrUpdateAdapter<LoaiTienTe>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_money_type` SET `money_id` = ?,`money_name` = ? WHERE `money_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LoaiTienTe value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getId());
      }
    };
  }

  @Override
  public void themTienTe(final LoaiTienTe loaiTienTe) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoaiTienTe.insert(loaiTienTe);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void capNhatLoaiTienTe(final LoaiTienTe loaiTienTe) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfLoaiTienTe.handle(loaiTienTe);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<LoaiTienTe> xuatLoaiTienTe() {
    final String _sql = "SELECT * FROM tb_money_type WHERE money_id LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_money_type"}, false, new Callable<LoaiTienTe>() {
      @Override
      public LoaiTienTe call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "money_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "money_name");
          final LoaiTienTe _result;
          if(_cursor.moveToFirst()) {
            _result = new LoaiTienTe();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _result.setId(_tmpId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _result.setName(_tmpName);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LoaiTienTe loaiTienTe() {
    final String _sql = "SELECT * FROM tb_money_type WHERE money_id LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "money_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "money_name");
      final LoaiTienTe _result;
      if(_cursor.moveToFirst()) {
        _result = new LoaiTienTe();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
