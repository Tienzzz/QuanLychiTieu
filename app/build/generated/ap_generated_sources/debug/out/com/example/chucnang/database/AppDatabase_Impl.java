package com.example.chucnang.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DanhMucDao _danhMucDao;

  private volatile LoaiTienTeDao _loaiTienTeDao;

  private volatile ViTienDao _viTienDao;

  private volatile ChiTieuDao _chiTieuDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_category` (`cat_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cat_name` TEXT, `cat_img` TEXT, `cat_type` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_money_type` (`money_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `money_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_wallet` (`wallet_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `wallet_img` TEXT, `wallet_name` TEXT, `wallet_money` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_expense` (`exp_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `exp_note` TEXT, `exp_money` TEXT, `exp_date` INTEGER, `exp_type` INTEGER NOT NULL, `exp_cat` INTEGER NOT NULL, `exp_wallet` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f5dc38a06122d998fe29ee90ced9cbe2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tb_category`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_money_type`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_wallet`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_expense`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTbCategory = new HashMap<String, TableInfo.Column>(4);
        _columnsTbCategory.put("cat_id", new TableInfo.Column("cat_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbCategory.put("cat_name", new TableInfo.Column("cat_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbCategory.put("cat_img", new TableInfo.Column("cat_img", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbCategory.put("cat_type", new TableInfo.Column("cat_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbCategory = new TableInfo("tb_category", _columnsTbCategory, _foreignKeysTbCategory, _indicesTbCategory);
        final TableInfo _existingTbCategory = TableInfo.read(_db, "tb_category");
        if (! _infoTbCategory.equals(_existingTbCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_category(com.example.chucnang.model.DanhMuc).\n"
                  + " Expected:\n" + _infoTbCategory + "\n"
                  + " Found:\n" + _existingTbCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsTbMoneyType = new HashMap<String, TableInfo.Column>(2);
        _columnsTbMoneyType.put("money_id", new TableInfo.Column("money_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbMoneyType.put("money_name", new TableInfo.Column("money_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbMoneyType = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbMoneyType = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbMoneyType = new TableInfo("tb_money_type", _columnsTbMoneyType, _foreignKeysTbMoneyType, _indicesTbMoneyType);
        final TableInfo _existingTbMoneyType = TableInfo.read(_db, "tb_money_type");
        if (! _infoTbMoneyType.equals(_existingTbMoneyType)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_money_type(com.example.chucnang.model.LoaiTienTe).\n"
                  + " Expected:\n" + _infoTbMoneyType + "\n"
                  + " Found:\n" + _existingTbMoneyType);
        }
        final HashMap<String, TableInfo.Column> _columnsTbWallet = new HashMap<String, TableInfo.Column>(4);
        _columnsTbWallet.put("wallet_id", new TableInfo.Column("wallet_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbWallet.put("wallet_img", new TableInfo.Column("wallet_img", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbWallet.put("wallet_name", new TableInfo.Column("wallet_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbWallet.put("wallet_money", new TableInfo.Column("wallet_money", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbWallet = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbWallet = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbWallet = new TableInfo("tb_wallet", _columnsTbWallet, _foreignKeysTbWallet, _indicesTbWallet);
        final TableInfo _existingTbWallet = TableInfo.read(_db, "tb_wallet");
        if (! _infoTbWallet.equals(_existingTbWallet)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_wallet(com.example.chucnang.model.ViTien).\n"
                  + " Expected:\n" + _infoTbWallet + "\n"
                  + " Found:\n" + _existingTbWallet);
        }
        final HashMap<String, TableInfo.Column> _columnsTbExpense = new HashMap<String, TableInfo.Column>(7);
        _columnsTbExpense.put("exp_id", new TableInfo.Column("exp_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_note", new TableInfo.Column("exp_note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_money", new TableInfo.Column("exp_money", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_date", new TableInfo.Column("exp_date", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_type", new TableInfo.Column("exp_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_cat", new TableInfo.Column("exp_cat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbExpense.put("exp_wallet", new TableInfo.Column("exp_wallet", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbExpense = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbExpense = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbExpense = new TableInfo("tb_expense", _columnsTbExpense, _foreignKeysTbExpense, _indicesTbExpense);
        final TableInfo _existingTbExpense = TableInfo.read(_db, "tb_expense");
        if (! _infoTbExpense.equals(_existingTbExpense)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_expense(com.example.chucnang.model.ChiTieu).\n"
                  + " Expected:\n" + _infoTbExpense + "\n"
                  + " Found:\n" + _existingTbExpense);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f5dc38a06122d998fe29ee90ced9cbe2", "bdfd6aa34455fe06e4fc7a35472bc3db");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tb_category","tb_money_type","tb_wallet","tb_expense");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tb_category`");
      _db.execSQL("DELETE FROM `tb_money_type`");
      _db.execSQL("DELETE FROM `tb_wallet`");
      _db.execSQL("DELETE FROM `tb_expense`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DanhMucDao.class, DanhMucDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LoaiTienTeDao.class, LoaiTienTeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ViTienDao.class, ViTienDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChiTieuDao.class, ChiTieuDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public DanhMucDao danhMucDao() {
    if (_danhMucDao != null) {
      return _danhMucDao;
    } else {
      synchronized(this) {
        if(_danhMucDao == null) {
          _danhMucDao = new DanhMucDao_Impl(this);
        }
        return _danhMucDao;
      }
    }
  }

  @Override
  public LoaiTienTeDao loaiTienTeDao() {
    if (_loaiTienTeDao != null) {
      return _loaiTienTeDao;
    } else {
      synchronized(this) {
        if(_loaiTienTeDao == null) {
          _loaiTienTeDao = new LoaiTienTeDao_Impl(this);
        }
        return _loaiTienTeDao;
      }
    }
  }

  @Override
  public ViTienDao viTienDao() {
    if (_viTienDao != null) {
      return _viTienDao;
    } else {
      synchronized(this) {
        if(_viTienDao == null) {
          _viTienDao = new ViTienDao_Impl(this);
        }
        return _viTienDao;
      }
    }
  }

  @Override
  public ChiTieuDao chiTieuDao() {
    if (_chiTieuDao != null) {
      return _chiTieuDao;
    } else {
      synchronized(this) {
        if(_chiTieuDao == null) {
          _chiTieuDao = new ChiTieuDao_Impl(this);
        }
        return _chiTieuDao;
      }
    }
  }
}
