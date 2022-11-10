-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 28, 2021 lúc 04:42 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `player`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donate`
--

CREATE TABLE `donate` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `card` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `statuss` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `time_in` timestamp NULL DEFAULT current_timestamp(),
  `time_out` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donate`
--

INSERT INTO `donate` (`username`, `card`, `statuss`, `time_in`, `time_out`) VALUES
('dinhnam', '50K', 'request', '2021-12-26 17:00:00', '2021-12-26 17:00:00'),
('khabanh', '500K', 'success', '2021-12-26 17:00:00', '2021-12-28 15:40:14'),
('dinhnam', '20k', 'request', '2021-12-27 17:00:00', '2021-12-26 17:00:00'),
('dinhnam', '50K', 'request', '2021-12-27 17:00:00', '2021-12-26 17:00:00'),
('khabanh', '290K', 'success', '2021-12-27 17:00:00', '2021-12-28 15:40:14'),
('khabanh', '100K', 'success', '2021-12-27 17:00:00', '2021-12-28 15:40:14'),
('khabanh', '150K', 'success', '2021-12-27 17:00:00', '2021-12-28 15:40:14'),
('khabanh', '450k', 'success', '2021-12-28 12:00:38', '2021-12-28 15:40:14'),
('khabanh', '10K', 'success', '2021-12-28 13:57:31', '2021-12-28 15:40:14'),
('khabanh', '20K', 'success', '2021-12-28 14:00:11', '2021-12-28 15:40:14'),
('khabanh', '5K', 'success', '2021-12-28 15:40:39', '2021-12-28 15:41:09');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`username`, `password`, `fullname`, `email`, `role`) VALUES
('dinhnam', '123', 'Nguyễn Đình Nam', 'nguynam69@gmail.com', 1),
('khabanh', '123', 'Ngô Bá Khá', 'khabanh123@gmail.com', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `donate`
--
ALTER TABLE `donate`
  ADD KEY `username` (`username`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `donate`
--
ALTER TABLE `donate`
  ADD CONSTRAINT `donate_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
