# PTUD
# Ứng dụng Quản Lý Chi Tiêu Cá Nhân

Đây là một ứng dụng Android giúp người dùng theo dõi và quản lý chi tiêu hàng ngày, hỗ trợ ghi chép các khoản thu/chi, phân loại giao dịch, và thống kê chi tiêu theo thời gian.

## Tính năng chính

- Thêm, sửa, xoá khoản chi tiêu
- Lưu lịch sử chi tiêu theo ngày/tháng/năm
- Phân loại thu/chi theo danh mục
- Thống kê tổng quan chi tiêu
- Tìm kiếm giao dịch theo từ khóa
- Lưu trữ cục bộ bằng SQLite
- Giao diện đơn giản, dễ sử dụng

## Công nghệ sử dụng

| Thành phần       | Công nghệ        |
|------------------|------------------|
| Ngôn ngữ         | Java             |
| Nền tảng         | Android (Studio) |
| Cơ sở dữ liệu    | SQLite           |
| UI/UX            | XML Layout       |
| IDE              | Android Studio   |

## Cấu trúc thư mục

```plaintext
QuanLiChiTieu-main/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/quanlichitieu/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── AddActivity.java
│   │   │   │   └── ...
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       └── drawable/
│   │   └── AndroidManifest.xml
│   └── build.gradle
└── README.md
