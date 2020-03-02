-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 02, 2020 at 01:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ExamSys`
--

-- --------------------------------------------------------

--
-- Table structure for table `QuesTB`
--

CREATE TABLE `QuesTB` (
  `QID` int(10) NOT NULL,
  `Subject` varchar(100) NOT NULL,
  `Qno` int(10) NOT NULL,
  `Question` varchar(100) NOT NULL,
  `Option1` varchar(100) NOT NULL,
  `Option2` varchar(100) NOT NULL,
  `Option3` varchar(100) NOT NULL,
  `Option4` varchar(100) NOT NULL,
  `CorrectOption` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `QuesTB`
--

INSERT INTO `QuesTB` (`QID`, `Subject`, `Qno`, `Question`, `Option1`, `Option2`, `Option3`, `Option4`, `CorrectOption`) VALUES
(1, 'Java', 1, 'Who is known as the father of Java Programming Language?', 'James Gosling', 'M.P Java', 'Charel Babbage', 'Blais Pascal', 'James Gosling'),
(2, 'Java', 2, 'In Java control statements break,continue,return,try-catch-finally and assert belongs to', 'Selection statements', 'Loop statements', 'Transfer statements', 'Pause statements', 'Loop statements'),
(3, 'Java', 3, 'Which provides runtime environment for Java byte code to be executed?', 'JDK', 'JVM', 'JRE', 'JAVAC', 'JVM'),
(4, 'Java', 4, 'Which of the following are not Java keywords?', 'doubles', 'switch', 'then', 'instanceof', 'then'),
(5, 'Java', 5, 'Which of these operators is used to allocate memory to array variables in Java?', 'Alloc', 'Malloc', 'New Malloc', 'New', 'New'),
(6, 'Java', 6, 'Which of these is returned by operator \'&\'?', 'Integer', 'Character', 'Boolean', 'Float', 'Character'),
(7, 'Java', 7, 'Data type long literals are appended by', 'Uppercase L', 'Lowercase L', 'Long', 'Both Option1 and Option2', 'Both Option1 and Option2'),
(8, 'Java', 8, 'Java language was initially called as', 'Sumatra', 'J++', 'Oak', 'Pine', 'Oak'),
(9, 'Java', 9, 'Which one is a template for creating different objects?', 'An Array', 'A class', 'Interface', 'Method', 'A class'),
(10, 'Java', 10, 'Which symbols is used to contain the value of automatically initialized arrays?', 'Brackets', 'Braces', 'Parentheses', 'Comma', 'Braces'),
(11, 'Java', 11, 'Java Programming follows', 'both compilation and interpretation.', 'compilation.', 'interpretation.', 'none of the above.', 'both compilation and interpretation.');

-- --------------------------------------------------------

--
-- Table structure for table `SignUpTB`
--

CREATE TABLE `SignUpTB` (
  `SID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Year` text NOT NULL,
  `Stream` text NOT NULL,
  `Roll` bigint(11) NOT NULL,
  `Username` text NOT NULL,
  `Password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SignUpTB`
--

INSERT INTO `SignUpTB` (`SID`, `Name`, `Year`, `Stream`, `Roll`, `Username`, `Password`) VALUES
(1, 'Anal Mandal', '3rd', 'ECE', 24400316101, 'anal', '123'),
(2, 'Satyajit Patra', '3rd', 'ECE', 24400316043, 'satya', 'patra'),
(3, 'Suman Patra', '3rd', 'ME', 24400316070, 'suman', 'patra'),
(4, 'a', '2', 'IT', 10, 'a', 'a'),
(5, 'b', '1', 'CSE', 30, 'b', 'b'),
(6, 'C', '1', 'Cse', 50, 'C', 'C'),
(7, 'D', '4', 'EE', 32, 'D', 'd'),
(8, 'e', '3', 'e', 34, 'er', 'sf'),
(9, 'CC', '5', 'EE', 56, 'UR', 'yu'),
(10, 'ads', '3', 'sdf', 23, 'das', 'ads'),
(11, 'dfs', '1', 'eds', 21, 'fds', 'sf'),
(12, 'Ayush Saha', '3rd', 'ME', 24400216016, 'Ayush', '123'),
(13, 'Abc', '3', 'gdg', 98, 'Anal1', '1231');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `QuesTB`
--
ALTER TABLE `QuesTB`
  ADD PRIMARY KEY (`QID`);

--
-- Indexes for table `SignUpTB`
--
ALTER TABLE `SignUpTB`
  ADD PRIMARY KEY (`SID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `QuesTB`
--
ALTER TABLE `QuesTB`
  MODIFY `QID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `SignUpTB`
--
ALTER TABLE `SignUpTB`
  MODIFY `SID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
