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
import com.example.chucnang.model.ChiTieu;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChiTieuDao_Impl implements ChiTieuDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChiTieu> __insertionAdapterOfChiTieu;

  private final EntityDeletionOrUpdateAdapter<ChiTieu> __deletionAdapterOfChiTieu;

  private final EntityDeletionOrUpdateAdapter<ChiTieu> __updateAdapterOfChiTieu;

  public ChiTieuDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChiTieu = new EntityInsertionAdapter<ChiTieu>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_expense` (`exp_id`,`exp_note`,`exp_money`,`exp_date`,`exp_type`,`exp_cat`,`exp_wallet`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChiTieu value) {
        stmt.bindLong(1, value.getId());
        if (value.getNote() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNote());
        }
        if (value.getMoney() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMoney());
        }
        final long _tmp;
        _tmp = Converter.fromDate(value.getDate());
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getType());
        stmt.bindLong(6, value.getCategory());
        stmt.bindLong(7, value.getWallet());
      }
    };
    this.__deletionAdapterOfChiTieu = new EntityDeletionOrUpdateAdapter<ChiTieu>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_expense` WHERE `exp_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChiTieu value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfChiTieu = new EntityDeletionOrUpdateAdapter<ChiTieu>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_expense` SET `exp_id` = ?,`exp_note` = ?,`exp_money` = ?,`exp_date` = ?,`exp_type` = ?,`exp_cat` = ?,`exp_wallet` = ? WHERE `exp_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChiTieu value) {
        stmt.bindLong(1, value.getId());
        if (value.getNote() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNote());
        }
        if (value.getMoney() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMoney());
        }
        final long _tmp;
        _tmp = Converter.fromDate(value.getDate());
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getType());
        stmt.bindLong(6, value.getCategory());
        stmt.bindLong(7, value.getWallet());
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void themChiTieu(final ChiTieu... chiTieu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChiTieu.insert(chiTieu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void themNhieuChiTieu(final List<ChiTieu> chiTieuList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChiTieu.insert(chiTieuList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void xoaChiTieu(final ChiTieu chiTieu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChiTieu.handle(chiTieu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void capNhatChiTieu(final ChiTieu... chiTieu) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChiTieu.handleMultiple(chiTieu);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ChiTieu timChiTieuTheoID(final int uid) {
    final String _sql = "SELECT * FROM tb_expense WHERE exp_id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
      final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
      final ChiTieu _result;
      if(_cursor.moveToFirst()) {
        _result = new ChiTieu();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _result.setNote(_tmpNote);
        final String _tmpMoney;
        if (_cursor.isNull(_cursorIndexOfMoney)) {
          _tmpMoney = null;
        } else {
          _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
        }
        _result.setMoney(_tmpMoney);
        final Date _tmpDate;
        final long _tmp;
        _tmp = _cursor.getLong(_cursorIndexOfDate);
        _tmpDate = Converter.toDate(_tmp);
        _result.setDate(_tmpDate);
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        _result.setType(_tmpType);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _result.setCategory(_tmpCategory);
        final int _tmpWallet;
        _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
        _result.setWallet(_tmpWallet);
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
  public List<ChiTieu> xuatChiTieu() {
    final String _sql = "SELECT * FROM tb_expense ORDER BY exp_date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
      final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
      final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
      final List<ChiTieu> _result = new ArrayList<ChiTieu>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ChiTieu _item;
        _item = new ChiTieu();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNote;
        if (_cursor.isNull(_cursorIndexOfNote)) {
          _tmpNote = null;
        } else {
          _tmpNote = _cursor.getString(_cursorIndexOfNote);
        }
        _item.setNote(_tmpNote);
        final String _tmpMoney;
        if (_cursor.isNull(_cursorIndexOfMoney)) {
          _tmpMoney = null;
        } else {
          _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
        }
        _item.setMoney(_tmpMoney);
        final Date _tmpDate;
        final long _tmp;
        _tmp = _cursor.getLong(_cursorIndexOfDate);
        _tmpDate = Converter.toDate(_tmp);
        _item.setDate(_tmpDate);
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        _item.setType(_tmpType);
        final int _tmpCategory;
        _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
        _item.setCategory(_tmpCategory);
        final int _tmpWallet;
        _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
        _item.setWallet(_tmpWallet);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ChiTieu>> xuatChiTieuLive() {
    final String _sql = "SELECT * FROM tb_expense ORDER BY exp_date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_expense"}, false, new Callable<List<ChiTieu>>() {
      @Override
      public List<ChiTieu> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
          final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
          final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
          final List<ChiTieu> _result = new ArrayList<ChiTieu>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChiTieu _item;
            _item = new ChiTieu();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item.setNote(_tmpNote);
            final String _tmpMoney;
            if (_cursor.isNull(_cursorIndexOfMoney)) {
              _tmpMoney = null;
            } else {
              _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
            }
            _item.setMoney(_tmpMoney);
            final Date _tmpDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = Converter.toDate(_tmp);
            _item.setDate(_tmpDate);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            _item.setType(_tmpType);
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            final int _tmpWallet;
            _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
            _item.setWallet(_tmpWallet);
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
  public LiveData<List<ChiTieu>> xuatChiTieuLiveLimit5() {
    final String _sql = "SELECT * FROM tb_expense ORDER BY exp_date ASC,exp_id ASC limit 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_expense"}, false, new Callable<List<ChiTieu>>() {
      @Override
      public List<ChiTieu> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
          final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
          final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
          final List<ChiTieu> _result = new ArrayList<ChiTieu>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChiTieu _item;
            _item = new ChiTieu();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item.setNote(_tmpNote);
            final String _tmpMoney;
            if (_cursor.isNull(_cursorIndexOfMoney)) {
              _tmpMoney = null;
            } else {
              _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
            }
            _item.setMoney(_tmpMoney);
            final Date _tmpDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = Converter.toDate(_tmp);
            _item.setDate(_tmpDate);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            _item.setType(_tmpType);
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            final int _tmpWallet;
            _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
            _item.setWallet(_tmpWallet);
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
  public LiveData<List<ChiTieu>> xuatKhoanThuLive() {
    final String _sql = "SELECT * FROM tb_expense WHERE exp_type LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_expense"}, false, new Callable<List<ChiTieu>>() {
      @Override
      public List<ChiTieu> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
          final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
          final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
          final List<ChiTieu> _result = new ArrayList<ChiTieu>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChiTieu _item;
            _item = new ChiTieu();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item.setNote(_tmpNote);
            final String _tmpMoney;
            if (_cursor.isNull(_cursorIndexOfMoney)) {
              _tmpMoney = null;
            } else {
              _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
            }
            _item.setMoney(_tmpMoney);
            final Date _tmpDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = Converter.toDate(_tmp);
            _item.setDate(_tmpDate);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            _item.setType(_tmpType);
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            final int _tmpWallet;
            _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
            _item.setWallet(_tmpWallet);
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
  public LiveData<List<ChiTieu>> xuatKhoanChiLive() {
    final String _sql = "SELECT * FROM tb_expense WHERE exp_type LIKE 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_expense"}, false, new Callable<List<ChiTieu>>() {
      @Override
      public List<ChiTieu> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_id");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_note");
          final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_money");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_type");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_cat");
          final int _cursorIndexOfWallet = CursorUtil.getColumnIndexOrThrow(_cursor, "exp_wallet");
          final List<ChiTieu> _result = new ArrayList<ChiTieu>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChiTieu _item;
            _item = new ChiTieu();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpNote;
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _tmpNote = null;
            } else {
              _tmpNote = _cursor.getString(_cursorIndexOfNote);
            }
            _item.setNote(_tmpNote);
            final String _tmpMoney;
            if (_cursor.isNull(_cursorIndexOfMoney)) {
              _tmpMoney = null;
            } else {
              _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
            }
            _item.setMoney(_tmpMoney);
            final Date _tmpDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = Converter.toDate(_tmp);
            _item.setDate(_tmpDate);
            final int _tmpType;
            _tmpType = _cursor.getInt(_cursorIndexOfType);
            _item.setType(_tmpType);
            final int _tmpCategory;
            _tmpCategory = _cursor.getInt(_cursorIndexOfCategory);
            _item.setCategory(_tmpCategory);
            final int _tmpWallet;
            _tmpWallet = _cursor.getInt(_cursorIndexOfWallet);
            _item.setWallet(_tmpWallet);
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
