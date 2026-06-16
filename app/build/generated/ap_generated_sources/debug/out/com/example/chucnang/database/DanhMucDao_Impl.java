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
import com.example.chucnang.model.DanhMuc;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DanhMucDao_Impl implements DanhMucDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DanhMuc> __insertionAdapterOfDanhMuc;

  private final EntityDeletionOrUpdateAdapter<DanhMuc> __deletionAdapterOfDanhMuc;

  private final EntityDeletionOrUpdateAdapter<DanhMuc> __updateAdapterOfDanhMuc;

  public DanhMucDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDanhMuc = new EntityInsertionAdapter<DanhMuc>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_category` (`cat_id`,`cat_name`,`cat_img`,`cat_type`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DanhMuc value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenDanhMuc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenDanhMuc());
        }
        if (value.getHinhAnh() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHinhAnh());
        }
        stmt.bindLong(4, value.getLoaiDanhMuc());
      }
    };
    this.__deletionAdapterOfDanhMuc = new EntityDeletionOrUpdateAdapter<DanhMuc>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_category` WHERE `cat_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DanhMuc value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDanhMuc = new EntityDeletionOrUpdateAdapter<DanhMuc>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_category` SET `cat_id` = ?,`cat_name` = ?,`cat_img` = ?,`cat_type` = ? WHERE `cat_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DanhMuc value) {
        stmt.bindLong(1, value.getId());
        if (value.getTenDanhMuc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenDanhMuc());
        }
        if (value.getHinhAnh() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHinhAnh());
        }
        stmt.bindLong(4, value.getLoaiDanhMuc());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void themDanhMuc(final DanhMuc... danhMuc) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDanhMuc.insert(danhMuc);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void themNhieuDanhMuc(final List<DanhMuc> danhMucList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDanhMuc.insert(danhMucList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void xoaDanhMuc(final DanhMuc danhMuc) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDanhMuc.handle(danhMuc);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void capNhatDanhMuc(final DanhMuc danhMuc) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDanhMuc.handle(danhMuc);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DanhMuc> xuatDanhMuc() {
    final String _sql = "SELECT * FROM tb_category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_id");
      final int _cursorIndexOfTenDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_name");
      final int _cursorIndexOfHinhAnh = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_img");
      final int _cursorIndexOfLoaiDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_type");
      final List<DanhMuc> _result = new ArrayList<DanhMuc>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DanhMuc _item;
        _item = new DanhMuc();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTenDanhMuc;
        if (_cursor.isNull(_cursorIndexOfTenDanhMuc)) {
          _tmpTenDanhMuc = null;
        } else {
          _tmpTenDanhMuc = _cursor.getString(_cursorIndexOfTenDanhMuc);
        }
        _item.setTenDanhMuc(_tmpTenDanhMuc);
        final String _tmpHinhAnh;
        if (_cursor.isNull(_cursorIndexOfHinhAnh)) {
          _tmpHinhAnh = null;
        } else {
          _tmpHinhAnh = _cursor.getString(_cursorIndexOfHinhAnh);
        }
        _item.setHinhAnh(_tmpHinhAnh);
        final int _tmpLoaiDanhMuc;
        _tmpLoaiDanhMuc = _cursor.getInt(_cursorIndexOfLoaiDanhMuc);
        _item.setLoaiDanhMuc(_tmpLoaiDanhMuc);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DanhMuc timDanhMucTheoID(final int uid) {
    final String _sql = "SELECT * FROM tb_category WHERE cat_id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_id");
      final int _cursorIndexOfTenDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_name");
      final int _cursorIndexOfHinhAnh = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_img");
      final int _cursorIndexOfLoaiDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_type");
      final DanhMuc _result;
      if(_cursor.moveToFirst()) {
        _result = new DanhMuc();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpTenDanhMuc;
        if (_cursor.isNull(_cursorIndexOfTenDanhMuc)) {
          _tmpTenDanhMuc = null;
        } else {
          _tmpTenDanhMuc = _cursor.getString(_cursorIndexOfTenDanhMuc);
        }
        _result.setTenDanhMuc(_tmpTenDanhMuc);
        final String _tmpHinhAnh;
        if (_cursor.isNull(_cursorIndexOfHinhAnh)) {
          _tmpHinhAnh = null;
        } else {
          _tmpHinhAnh = _cursor.getString(_cursorIndexOfHinhAnh);
        }
        _result.setHinhAnh(_tmpHinhAnh);
        final int _tmpLoaiDanhMuc;
        _tmpLoaiDanhMuc = _cursor.getInt(_cursorIndexOfLoaiDanhMuc);
        _result.setLoaiDanhMuc(_tmpLoaiDanhMuc);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DanhMuc>> xuatDanhMucLive() {
    final String _sql = "SELECT * FROM tb_category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_category"}, false, new Callable<List<DanhMuc>>() {
      @Override
      public List<DanhMuc> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_id");
          final int _cursorIndexOfTenDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_name");
          final int _cursorIndexOfHinhAnh = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_img");
          final int _cursorIndexOfLoaiDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_type");
          final List<DanhMuc> _result = new ArrayList<DanhMuc>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DanhMuc _item;
            _item = new DanhMuc();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpTenDanhMuc;
            if (_cursor.isNull(_cursorIndexOfTenDanhMuc)) {
              _tmpTenDanhMuc = null;
            } else {
              _tmpTenDanhMuc = _cursor.getString(_cursorIndexOfTenDanhMuc);
            }
            _item.setTenDanhMuc(_tmpTenDanhMuc);
            final String _tmpHinhAnh;
            if (_cursor.isNull(_cursorIndexOfHinhAnh)) {
              _tmpHinhAnh = null;
            } else {
              _tmpHinhAnh = _cursor.getString(_cursorIndexOfHinhAnh);
            }
            _item.setHinhAnh(_tmpHinhAnh);
            final int _tmpLoaiDanhMuc;
            _tmpLoaiDanhMuc = _cursor.getInt(_cursorIndexOfLoaiDanhMuc);
            _item.setLoaiDanhMuc(_tmpLoaiDanhMuc);
            _result.add(_item);
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
  public LiveData<List<DanhMuc>> xuatDanhMucThu() {
    final String _sql = "SELECT * FROM tb_category WHERE cat_type LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_category"}, false, new Callable<List<DanhMuc>>() {
      @Override
      public List<DanhMuc> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_id");
          final int _cursorIndexOfTenDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_name");
          final int _cursorIndexOfHinhAnh = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_img");
          final int _cursorIndexOfLoaiDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_type");
          final List<DanhMuc> _result = new ArrayList<DanhMuc>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DanhMuc _item;
            _item = new DanhMuc();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpTenDanhMuc;
            if (_cursor.isNull(_cursorIndexOfTenDanhMuc)) {
              _tmpTenDanhMuc = null;
            } else {
              _tmpTenDanhMuc = _cursor.getString(_cursorIndexOfTenDanhMuc);
            }
            _item.setTenDanhMuc(_tmpTenDanhMuc);
            final String _tmpHinhAnh;
            if (_cursor.isNull(_cursorIndexOfHinhAnh)) {
              _tmpHinhAnh = null;
            } else {
              _tmpHinhAnh = _cursor.getString(_cursorIndexOfHinhAnh);
            }
            _item.setHinhAnh(_tmpHinhAnh);
            final int _tmpLoaiDanhMuc;
            _tmpLoaiDanhMuc = _cursor.getInt(_cursorIndexOfLoaiDanhMuc);
            _item.setLoaiDanhMuc(_tmpLoaiDanhMuc);
            _result.add(_item);
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
  public LiveData<List<DanhMuc>> xuatDanhMucChi() {
    final String _sql = "SELECT * FROM tb_category WHERE cat_type LIKE 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_category"}, false, new Callable<List<DanhMuc>>() {
      @Override
      public List<DanhMuc> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_id");
          final int _cursorIndexOfTenDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_name");
          final int _cursorIndexOfHinhAnh = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_img");
          final int _cursorIndexOfLoaiDanhMuc = CursorUtil.getColumnIndexOrThrow(_cursor, "cat_type");
          final List<DanhMuc> _result = new ArrayList<DanhMuc>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DanhMuc _item;
            _item = new DanhMuc();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpTenDanhMuc;
            if (_cursor.isNull(_cursorIndexOfTenDanhMuc)) {
              _tmpTenDanhMuc = null;
            } else {
              _tmpTenDanhMuc = _cursor.getString(_cursorIndexOfTenDanhMuc);
            }
            _item.setTenDanhMuc(_tmpTenDanhMuc);
            final String _tmpHinhAnh;
            if (_cursor.isNull(_cursorIndexOfHinhAnh)) {
              _tmpHinhAnh = null;
            } else {
              _tmpHinhAnh = _cursor.getString(_cursorIndexOfHinhAnh);
            }
            _item.setHinhAnh(_tmpHinhAnh);
            final int _tmpLoaiDanhMuc;
            _tmpLoaiDanhMuc = _cursor.getInt(_cursorIndexOfLoaiDanhMuc);
            _item.setLoaiDanhMuc(_tmpLoaiDanhMuc);
            _result.add(_item);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
