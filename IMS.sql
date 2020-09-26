-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 28, 2019 at 07:48 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `IMS`
--

-- --------------------------------------------------------

--
-- Table structure for table `balancesheet`
--

CREATE TABLE `balancesheet` (
  `SlNo` int(100) NOT NULL,
  `AccountName` varchar(100) NOT NULL,
  `Date` date DEFAULT NULL,
  `Category` varchar(100) NOT NULL,
  `AmountInUSD` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `balancesheet`
--

INSERT INTO `balancesheet` (`SlNo`, `AccountName`, `Date`, `Category`, `AmountInUSD`) VALUES
(1, 'Accounts Receivable', '2019-07-01', 'Assets', 400),
(2, 'Short Term Debit', '2019-07-02', 'Liabilities', 670),
(3, 'Taxes Payable', '2019-07-03', 'Liabilities', 300),
(4, 'Capital', '2019-07-04', 'Assets', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `currentstock`
--

CREATE TABLE `currentstock` (
  `SlNo` int(100) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `PriceUSD` int(100) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `Availability` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currentstock`
--

INSERT INTO `currentstock` (`SlNo`, `ProductName`, `PriceUSD`, `Category`, `Availability`) VALUES
(1, 'SAMSUNG LED 19\'\' INCH WIDE', 82, 'Monitor', 'In Stock'),
(2, 'INTEL CORE i5 8th Gen 3.26 GHz', 208, 'Processor', 'In Stock'),
(3, 'GIGABYTE H170 GAMING 3', 140, 'Motherboard', 'In Stock'),
(4, 'A4TECH OP62OD', 3, 'Mouse', 'Out of Stock'),
(5, 'Sample Product', 344, 'Processor', 'Out of Stock');

-- --------------------------------------------------------

--
-- Table structure for table `Employees`
--

CREATE TABLE `Employees` (
  `EmployeeId` int(100) NOT NULL,
  `EmployeeName` varchar(100) NOT NULL,
  `Designation` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL,
  `Salary` int(100) NOT NULL,
  `JoiningDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Employees`
--

INSERT INTO `Employees` (`EmployeeId`, `EmployeeName`, `Designation`, `Department`, `Salary`, `JoiningDate`) VALUES
(1, 'Asif Iqbal', 'Managing Director', 'Organization Management', 75000, '2015-01-01'),
(2, 'Rayhan Foysal', 'Production Manager', 'Organization Management', 55000, '2015-02-01'),
(3, 'Mohammad Abdur Rahman', 'Accountant Officer', 'Accounts', 45000, '2015-02-05');

-- --------------------------------------------------------

--
-- Table structure for table `logininfo`
--

CREATE TABLE `logininfo` (
  `UserName` varchar(100) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

INSERT INTO `logininfo` (`UserName`, `Email`, `Password`) VALUES
('', '', ''),
('', '', ''),
('', '', ''),
('', '', ''),
('', '', ''),
('a', 'a@gmail.com', 'a'),
('b', 'b@gmail.com', 'b'),
('', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `salarymanagement`
--

CREATE TABLE `salarymanagement` (
  `SlNo` int(100) NOT NULL,
  `EmployeeName` varchar(100) NOT NULL,
  `Designation` varchar(100) NOT NULL,
  `Salary` int(100) NOT NULL,
  `PaymentStatus` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salarymanagement`
--

INSERT INTO `salarymanagement` (`SlNo`, `EmployeeName`, `Designation`, `Salary`, `PaymentStatus`, `Department`) VALUES
(1, 'Asif Iqbal', 'Managing Director', 75000, 'Unpaid', 'Organization Management'),
(9, 'Asif Iqbal', 'Brand Manager', 1000000, 'Paid', 'Organization Management');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `balancesheet`
--
ALTER TABLE `balancesheet`
  ADD PRIMARY KEY (`SlNo`);

--
-- Indexes for table `currentstock`
--
ALTER TABLE `currentstock`
  ADD PRIMARY KEY (`SlNo`);

--
-- Indexes for table `Employees`
--
ALTER TABLE `Employees`
  ADD PRIMARY KEY (`EmployeeId`);

--
-- Indexes for table `salarymanagement`
--
ALTER TABLE `salarymanagement`
  ADD PRIMARY KEY (`SlNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
