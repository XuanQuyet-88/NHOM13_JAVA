CREATE DATABASE Product;
GO
USE Product;
GO
CREATE TABLE tblProduct (
    maSP NVARCHAR(50) NOT NULL CONSTRAINT PK_Pro PRIMARY KEY, 
    tenSP NVARCHAR(50), 
    moTa NVARCHAR(20), 
    kichThuoc NVARCHAR(20), 
    SoLuong INT, 
    Gia INT
);
INSERT INTO tblProduct VALUES 
(N'SP001', N'Tủ MOHO DALUMD 2 Cánh', N'Gỗ công nghiệp', N'1m2', 3000, 2490000),
(N'SP002', N'Ghế Sofa MOHO HALDEN 801', N'Gỗ cao su tự nhiên', N'180x85x82cm', 5000, 7650000),
(N'SP003', N'Kệ TV MOHO HOBRO 301', N'Gỗ tràm', N'450x1800x500', 3500, 6990000),
(N'SP004', N'Giường Ngủ MOHO FIJI 401', N'Gỗ tự nhiên', N'1m8', 1000, 8559000);

SELECT * FROM tblProduct;







