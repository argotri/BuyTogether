-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Mar 2019 pada 11.58
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `buytogether`
--

--
-- Dumping data untuk tabel `sku_bundle`
--

INSERT INTO `sku_bundle` (`id`, `sku`, `score`, `source`, `sku_list_id`) VALUES
(1, 'TOQ-15126-00416', 0.9, 'MANUAL_INPUT', 1),
(3, 'TOQ-15126-00417', 0.89, 'MANUAL_INPUT', 1);

--
-- Dumping data untuk tabel `sku_list`
--

INSERT INTO `sku_list` (`id`, `sku_code`, `added_by`) VALUES
(1, 'TOQ-15126-00415-00001', 'Admin');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
