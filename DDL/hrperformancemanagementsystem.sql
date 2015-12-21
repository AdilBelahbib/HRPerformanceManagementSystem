-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 21, 2015 at 01:05 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hrperformancemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `action`
--

CREATE TABLE IF NOT EXISTS `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionAction` varchar(256) NOT NULL,
  `idBip` int(11) NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idBip` (`idBip`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `bap`
--

CREATE TABLE IF NOT EXISTS `bap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBAP` datetime NOT NULL,
  `StatutBAP` varchar(128) NOT NULL DEFAULT 'EN_ATTENTE',
  `nombreRejet` int(11) NOT NULL DEFAULT '0',
  `idFicheObjectifsTraites` int(11) DEFAULT NULL,
  `idFicheObjectifsRediges` int(11) DEFAULT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  `idFicheEvaluationsInitialisee` int(11) DEFAULT NULL,
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`),
  KEY `idFicheObjectifsRediges` (`idFicheObjectifsRediges`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`),
  KEY `idCollaborateur` (`idCollaborateur`),
  KEY `idFicheEvaluationsInitialisee` (`idFicheEvaluationsInitialisee`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=28 ;

--
-- Dumping data for table `bap`
--

INSERT INTO `bap` (`id`, `dateBAP`, `StatutBAP`, `nombreRejet`, `idFicheObjectifsTraites`, `idFicheObjectifsRediges`, `idFicheEvaluations`, `idFicheEvaluationsInitialisee`, `idCollaborateur`) VALUES
(1, '2015-12-16 00:00:00', 'ANNULE', 0, NULL, 2, 1, 1, 154),
(2, '2015-12-02 00:00:00', 'EN_COURS', 0, 2, 3, 2, 1, 154),
(3, '2015-12-08 00:00:00', 'VALIDE', 0, 3, 3, NULL, 1, 154);

-- --------------------------------------------------------

--
-- Table structure for table `bip`
--

CREATE TABLE IF NOT EXISTS `bip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateBIP` datetime NOT NULL,
  `idFicheObjectifsTraites` int(11) NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifsTraites` (`idFicheObjectifsTraites`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `bip`
--

INSERT INTO `bip` (`id`, `dateBIP`, `idFicheObjectifsTraites`, `idCollaborateur`) VALUES
(2, '2015-12-10 00:00:00', 3, 154);

-- --------------------------------------------------------

--
-- Table structure for table `collaborateur`
--

CREATE TABLE IF NOT EXISTS `collaborateur` (
  `id` int(11) NOT NULL,
  `id_manager` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_manager` (`id_manager`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `collaborateur`
--

INSERT INTO `collaborateur` (`id`, `id_manager`) VALUES
(154, 151),
(156, 151),
(157, 151);

-- --------------------------------------------------------

--
-- Table structure for table `demande_bip`
--

CREATE TABLE IF NOT EXISTS `demande_bip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDemande` date NOT NULL,
  `idCollaborateur` int(11) NOT NULL,
  `idEncadrant` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`),
  KEY `idEncadrant` (`idEncadrant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `demande_bip`
--

INSERT INTO `demande_bip` (`id`, `dateDemande`, `idCollaborateur`, `idEncadrant`) VALUES
(1, '2015-12-04', 154, 149);

-- --------------------------------------------------------

--
-- Table structure for table `entete`
--

CREATE TABLE IF NOT EXISTS `entete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebutIntervention` date DEFAULT NULL,
  `dateFinIntervention` date DEFAULT NULL,
  `role` varchar(64) DEFAULT NULL,
  `nombreJoursValorises` int(11) DEFAULT NULL,
  `codeProjet` int(11) NOT NULL,
  `nomProjet` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poids` int(11) NOT NULL,
  `resultat` double DEFAULT NULL,
  `idEncadrant` int(11) NOT NULL,
  `idObjectif` int(11) NOT NULL,
  `idFicheEvaluations` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEncadrant` (`idEncadrant`,`idObjectif`),
  KEY `foreign key` (`idObjectif`),
  KEY `idFicheEvaluations` (`idFicheEvaluations`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remarqueGenerale` varchar(1024) NOT NULL,
  `validation` bit(1) NOT NULL,
  `idEntete` int(11) DEFAULT NULL,
  `idEncadrant` int(11) NOT NULL,
  `idBap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEndacrant` (`idEncadrant`),
  KEY `idEntete` (`idEntete`),
  KEY `idBap` (`idBap`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Table structure for table `fiche_evaluations`
--

CREATE TABLE IF NOT EXISTS `fiche_evaluations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEvaluation` datetime NOT NULL,
  `autorisationAcces` bit(1) DEFAULT b'1',
  `idCollaborateur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `fiche_evaluations`
--

INSERT INTO `fiche_evaluations` (`id`, `dateEvaluation`, `autorisationAcces`, `idCollaborateur`) VALUES
(1, '2015-12-07 00:00:00', b'1', 154),
(2, '2015-12-09 00:00:00', b'1', 154);

-- --------------------------------------------------------

--
-- Table structure for table `fiche_objectifs`
--

CREATE TABLE IF NOT EXISTS `fiche_objectifs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateFicheObjectifs` datetime NOT NULL,
  `autorisationAcces` bit(1) NOT NULL DEFAULT b'1',
  `idCollaborateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign key` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `fiche_objectifs`
--

INSERT INTO `fiche_objectifs` (`id`, `dateFicheObjectifs`, `autorisationAcces`, `idCollaborateur`) VALUES
(2, '2015-12-24 00:00:00', b'1', 156),
(3, '2015-12-09 00:00:00', b'1', 154);

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autoformation` bit(1) NOT NULL,
  `idBip` int(11) DEFAULT NULL,
  `idCollaborateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idBip` (`idBip`),
  KEY `idCollaborateur` (`idCollaborateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Table structure for table `objectif`
--

CREATE TABLE IF NOT EXISTS `objectif` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionObjectif` varchar(512) NOT NULL,
  `mesureObjectif` varchar(512) NOT NULL,
  `avancementObjectif` double NOT NULL DEFAULT '0',
  `idFicheObjectifs` int(11) DEFAULT NULL,
  `idFormation` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFicheObjectifs` (`idFicheObjectifs`),
  KEY `idFormation` (`idFormation`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `objectif`
--

INSERT INTO `objectif` (`id`, `descriptionObjectif`, `mesureObjectif`, `avancementObjectif`, `idFicheObjectifs`, `idFormation`, `idProjet`) VALUES
(3, 'hahwa', 'xgxfgfxgxfg', 50, 2, NULL, 14),
(4, 'xfgxfgxgxc', 'sfgsfgsfzdzz', 90, 3, NULL, 15),
(5, 'hadi lli khassha tji2', 'sfgsfgsfdadaa', 10, 3, NULL, 15),
(17, 'ddd', 'ddd', 50, NULL, NULL, NULL),
(18, 'aad', 'ddda', 40, NULL, NULL, NULL),
(30, 'aaaa', 'aaaa', 78, NULL, NULL, NULL),
(31, 'lelele', 'lelele', 30, NULL, NULL, NULL),
(32, 'lelele', 'lelele', 30, NULL, NULL, NULL),
(33, 'lelele', 'lelele', 30, NULL, NULL, NULL),
(34, 'lelele', 'lelele', 30, NULL, NULL, NULL),
(35, 'lelele', 'lelele', 30, NULL, NULL, NULL),
(36, 'lelele', 'lelele', 30, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProfile` varchar(16) NOT NULL,
  `descriptionProfile` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codeProfile` (`codeProfile`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `codeProfile`, `descriptionProfile`) VALUES
(1, 'DEV', 'Developpeur'),
(2, 'DRH', 'Directeur des ressources Humaines'),
(3, 'RAD', 'Recherche & Developpement');

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeProjet` varchar(16) NOT NULL,
  `nomProjet` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `codeProjet`, `nomProjet`) VALUES
(13, 'AB', 'blabla'),
(14, 'AB', 'blabla'),
(15, 'AB', 'blabla'),
(16, 'AB', 'blabla'),
(17, 'AB', 'blabla'),
(18, 'AB', 'blabla'),
(19, 'AB', 'blabla');

-- --------------------------------------------------------

--
-- Table structure for table `qualification_theme`
--

CREATE TABLE IF NOT EXISTS `qualification_theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(128) NOT NULL,
  `qualification` varchar(128) NOT NULL,
  `remarque` varchar(512) DEFAULT NULL,
  `idFeedback` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFeedback` (`idFeedback`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `motDePasse` varchar(128) NOT NULL,
  `nom` varchar(64) NOT NULL,
  `prenom` varchar(64) NOT NULL,
  `typeUtilisateur` varchar(2) NOT NULL DEFAULT 'C',
  `idProfile` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `idProfile` (`idProfile`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=165 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `nom`, `prenom`, `typeUtilisateur`, `idProfile`) VALUES
(149, 'adil@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'testing2', 'Adil', 'E', NULL),
(150, 'hamza@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'TANJI', 'Hamza', 'A', NULL),
(151, 'tanji@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'testing2', 'Hamza', 'M', NULL),
(154, 'belahbib@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'testing', 'Adil', 'C', NULL),
(155, 'belahbib2@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB155', 'Adil2', 'C', NULL),
(156, 'belahbib3@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB2156', 'Adil2', 'C', NULL),
(157, 'belahbib4@mail.com', '1829bca2a2e6210239ce329dabf70722a71d8873', 'BELAHBIB157', 'Adil2', 'C', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `action_ibfk_2` FOREIGN KEY (`idBip`) REFERENCES `bip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `action_ibfk_3` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bap`
--
ALTER TABLE `bap`
  ADD CONSTRAINT `bap_ibfk_2` FOREIGN KEY (`idFicheObjectifsRediges`) REFERENCES `fiche_objectifs` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `bap_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `bap_ibfk_4` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `bap_ibfk_5` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bap_ibfk_6` FOREIGN KEY (`idFicheEvaluationsInitialisee`) REFERENCES `fiche_evaluations` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `bip`
--
ALTER TABLE `bip`
  ADD CONSTRAINT `bip_ibfk_1` FOREIGN KEY (`idFicheObjectifsTraites`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bip_ibfk_2` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD CONSTRAINT `collaborateur_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `collaborateur_ibfk_2` FOREIGN KEY (`id_manager`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `demande_bip`
--
ALTER TABLE `demande_bip`
  ADD CONSTRAINT `demande_bip_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demande_bip_ibfk_2` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_2` FOREIGN KEY (`idObjectif`) REFERENCES `objectif` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `evaluation_ibfk_3` FOREIGN KEY (`idFicheEvaluations`) REFERENCES `fiche_evaluations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`idEncadrant`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`idEntete`) REFERENCES `entete` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `feedback_ibfk_4` FOREIGN KEY (`idBap`) REFERENCES `bap` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_evaluations`
--
ALTER TABLE `fiche_evaluations`
  ADD CONSTRAINT `fiche_evaluations_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fiche_objectifs`
--
ALTER TABLE `fiche_objectifs`
  ADD CONSTRAINT `fiche_objectifs_ibfk_1` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_2` FOREIGN KEY (`idBip`) REFERENCES `bip` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `formation_ibfk_3` FOREIGN KEY (`idCollaborateur`) REFERENCES `collaborateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `objectif`
--
ALTER TABLE `objectif`
  ADD CONSTRAINT `objectif_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `objectif_ibfk_1` FOREIGN KEY (`idFicheObjectifs`) REFERENCES `fiche_objectifs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `objectif_ibfk_3` FOREIGN KEY (`idFormation`) REFERENCES `formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qualification_theme`
--
ALTER TABLE `qualification_theme`
  ADD CONSTRAINT `qualification_theme_ibfk_1` FOREIGN KEY (`idFeedback`) REFERENCES `feedback` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`idProfile`) REFERENCES `profile` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
