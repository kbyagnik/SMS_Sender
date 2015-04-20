-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 28, 2015 at 08:11 AM
-- Server version: 5.5.37-0ubuntu0.13.10.1
-- PHP Version: 5.5.3-1ubuntu2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `android_api1`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking_status`
--

CREATE TABLE IF NOT EXISTS `booking_status` (
  `id` varchar(50) NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking_status`
--

INSERT INTO `booking_status` (`id`, `status`) VALUES
('aaloo', 'confirm'),
('aaloo1', 'waiting'),
('aaloo2', 'confirm'),
('aaloo3', 'confirm'),
('aaloo4', 'confirm'),
('aaloo5', 'suspended');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `sender` varchar(50) NOT NULL,
  `body` varchar(100) NOT NULL,
  `created_at` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`sender`,`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`sender`, `body`, `created_at`) VALUES
('+919646218688', 'Booking Status aaloo2 sen', '1427492626'),
('+919646218688', 'Booking Status aaloo1 cen', '1427493425'),
('+919646218688', 'Booking Status aaloo4 nAme', '1427494002'),
('+919780587802', 'Booking Status aaloo2 rndj ', '1427492864'),
('VK-WAYSMS', '9646218688:\nhi plz db mei dal jaiyo\n-\n Reply via way2sms.com. Now available on your mobile.', '1427447222'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427486149'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427486648'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427487322'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo3\n-\n Reply via way2sms.com. Now available on your mobile.', '1427487915'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo4\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488130'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488230'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488486'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488653'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo1 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427489769'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2 ram\n-\n Reply via way2sms.com. Now available on your mobile.', '1427489916'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2 suresh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427490181'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo3\n-\n Reply via way2sms.com. Now available on your mobile.', '1427490358'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427490393'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2 suresh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427490643'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo3 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427490869'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo3 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427491265'),
('VK-WAYSMS', '9646218688:\nBooking Status aaloo2 vds\n-\n Reply via way2sms.com. Now available on your mobile.', '1427492493'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427486388'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427487678'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo2\n-\n Reply via way2sms.com. Now available on your mobile.', '1427487847'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488776'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1 aaa\n-\n Reply via way2sms.com. Now available on your mobile.', '1427488909'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427489000'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427489155'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo1 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427489229'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo2 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427493045'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo2 ramesh\n-\n Reply via way2sms.com. Now available on your mobile.', '1427493332'),
('VM-WAYSMS', '9646218688:\nBooking Status aaloo2 remned\n-\n Reply via way2sms.com. Now available on your mobile.', '1427493805');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
