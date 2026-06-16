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
import com.example.chucnang.model.ViTien;
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
public final class ViTienDao_Impl implements ViTienDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ViTien> __insertionAdapterOfViTien;

  private final EntityDeletionOrUpdateAdapter<ViTien> __deletionAdapterOfViTien;

  private final EntityDeletionOrUpdateAdapter<ViTien> __updateAdapterOfViTien;

  public ViTienDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfViTien = new EntityInsertionAdapter<ViTien>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_wallet` (`wallet_id`,`wallet_img`,`wallet_name`,`wallet_money`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ViTien value) {
        stmt.bindLong(1, value.getId());
        if (value.getImg() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImg());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getMoney() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMoney());
        }
      }
    };
    this.__deletionAdapterOfViTien = new EntityDeletionOrUpdateAdapter<ViTien>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_wallet` WHERE `wallet_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ViTien value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfViTien = new EntityDeletionOrUpdateAdapter<ViTien>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_wallet` SET `wallet_id` = ?,`wallet_img` = ?,`wallet_name` = ?,`wallet_money` = ? WHERE `wallet_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ViTien value) {
        stmt.bindLong(1, value.getId());
        if (value.getImg() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImg());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getMoney() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMoney());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void themViTien(final ViTien... viTien) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfViTien.insert(viTien);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void themNhieuViTien(final List<ViTien> viTienList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfViTien.insert(viTienList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void xoaViTien(final ViTien viTien) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfViTien.handle(viTien);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void capNhatViTien(final ViTien... viTien) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfViTien.handleMultiple(viTien);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ViTien> xuatViTien() {
    final String _sql = "SELECT * FROM tb_wallet";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_id");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_img");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_money");
      final List<ViTien> _result = new ArrayList<ViTien>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ViTien _item;
        _item = new ViTien();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getString(_cursorIndexOfImg);
        }
        _item.setImg(_tmpImg);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpMoney;
        if (_cursor.isNull(_cursorIndexOfMoney)) {
          _tmpMoney = null;
        } else {
          _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
        }
        _item.setMoney(_tmpMoney);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ViTien timViTienTheoID(final int uid) {
    final String _sql = "SELECT * FROM tb_wallet WHERE wallet_id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_id");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_img");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_money");
      final ViTien _result;
      if(_cursor.moveToFirst()) {
        _result = new ViTien();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getString(_cursorIndexOfImg);
        }
        _result.setImg(_tmpImg);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpMoney;
        if (_cursor.isNull(_cursorIndexOfMoney)) {
          _tmpMoney = null;
        } else {
          _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
        }
        _result.setMoney(_tmpMoney);
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
  public LiveData<List<ViTien>> xuatViTienLive() {
    final String _sql = "SELECT * FROM tb_wallet";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_wallet"}, false, new Callable<List<ViTien>>() {
      @Override
      public List<ViTien> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_id");
          final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_img");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_name");
          final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "wallet_money");
          final List<ViTien> _result = new ArrayList<ViTien>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ViTien _item;
            _item = new ViTien();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpImg;
            if (_cursor.isNull(_cursorIndexOfImg)) {
              _tmpImg = null;
            } else {
              _tmpImg = _cursor.getString(_cursorIndexOfImg);
            }
            _item.setImg(_tmpImg);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpMoney;
            if (_cursor.isNull(_cursorIndexOfMoney)) {
              _tmpMoney = null;
            } else {
              _tmpMoney = _cursor.getString(_cursorIndexOfMoney);
            }
            _item.setMoney(_tmpMoney);
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
