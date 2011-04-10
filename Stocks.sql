-- phpMyAdmin SQL Dump
-- version 3.3.7deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 09, 2011 at 07:03 PM
-- Server version: 5.1.49
-- PHP Version: 5.3.3-1ubuntu9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Stocks`
--

-- --------------------------------------------------------

--
-- Table structure for table `CompanyInfo`
--

CREATE TABLE IF NOT EXISTS `CompanyInfo` (
  `Symbol` varchar(5) NOT NULL,
  `CompanyName` varchar(20) NOT NULL,
  PRIMARY KEY (`Symbol`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='The table stores the mapping between Company symbol and othe';

--
-- Dumping data for table `CompanyInfo`
--


-- --------------------------------------------------------

--
-- Table structure for table `livestock`
--

CREATE TABLE IF NOT EXISTS `livestock` (
  `symbol` varchar(5) NOT NULL DEFAULT '',
  `date` date NOT NULL,
  `price` double(8,4) NOT NULL,
  `percentChange` double(4,2) NOT NULL,
  `yield` double(4,2) NOT NULL,
  `p/e` double(4,2) NOT NULL,
  `peg` double(4,2) NOT NULL,
  `short` double(4,2) NOT NULL,
  `range` varchar(20) NOT NULL,
  `50Davg` double(4,2) NOT NULL,
  `50Chng` double(4,2) NOT NULL,
  `200Davg` double(4,2) NOT NULL,
  `200Chng` double(4,2) NOT NULL,
  `1YTarget` double(4,2) NOT NULL,
  `volume` double(11,1) NOT NULL,
  `avgVolume` double(11,1) NOT NULL,
  UNIQUE KEY `symbol` (`symbol`,`date`,`price`,`percentChange`,`yield`,`p/e`,`peg`,`short`,`range`,`50Davg`,`50Chng`,`200Davg`,`200Chng`,`1YTarget`,`volume`,`avgVolume`),
  UNIQUE KEY `symbol_2` (`symbol`,`date`,`price`,`percentChange`,`yield`,`p/e`,`peg`,`short`,`range`,`50Davg`,`50Chng`,`200Davg`,`200Chng`,`1YTarget`,`volume`,`avgVolume`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livestock`
--

INSERT INTO `livestock` (`symbol`, `date`, `price`, `percentChange`, `yield`, `p/e`, `peg`, `short`, `range`, `50Davg`, `50Chng`, `200Davg`, `200Chng`, `1YTarget`, `volume`, `avgVolume`) VALUES
('AA', '2011-03-04', 16.5700, -0.33, 0.72, 68.72, 0.84, 2.00, '"16.37 - 16.80"', 16.73, -0.93, 13.94, 18.91, 19.55, 18617484.0, 28989900.0),
('AADR', '2011-03-04', 16.5700, -0.33, 0.72, 68.72, 0.84, 2.00, '16.37 - 16.80', 16.73, -0.93, 13.94, 18.91, 19.55, 18617484.0, 28989900.0),
('AADR', '2011-03-04', 30.6000, -0.10, 0.00, 0.00, 0.00, 0.00, '"30.558 - 30.60"', 30.20, 1.34, 28.77, 6.37, 0.00, 899.0, 4079.0),
('AAI', '2011-03-04', 7.2800, -0.14, 0.00, 28.15, 4.19, 11.80, '"7.28 - 7.32"', 7.40, -1.59, 6.81, 6.88, 0.00, 7.0, 1357534.0),
('AAN', '2011-03-04', 23.0400, -0.26, 0.21, 16.04, 1.13, 16.80, '"22.73 - 23.21"', 19.83, 16.16, 18.36, 25.49, 0.00, 26.0, 460806.0),
('AAN.A', '2011-03-04', 0.0000, 0.00, 0.00, 0.00, 0.00, 0.00, '"N/A - N/A"', 0.00, 0.00, 0.00, 0.00, 0.00, 0.0, 0.0);
