-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2021 at 02:23 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `researchmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `researches`
--

CREATE TABLE `researches` (
  `researcherid` int(10) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `ContactNo` varchar(12) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researches`
--

INSERT INTO `researches` (`researcherid`, `Name`, `ContactNo`, `Email`) VALUES
(5, 'Senal', '0714525610', 'senalwijesiri98@gmail.com'),
(6, 'Kavish', '0765542037', 'kavishsubasinghe@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `researches`
--
ALTER TABLE `researches`
  ADD PRIMARY KEY (`researcherid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `researches`
--
ALTER TABLE `researches`
  MODIFY `researcherid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
