# Laboratory 1 - Paper, Please Classification System

## Project Overview

This project is a Java-based solution inspired by the game Papers, Please. The goal is to classify individuals into fictional universes (such as Star Wars, Marvel, Lord of the Rings, etc.) based on specific characteristics such as their planet, age, humanoid status, and traits. The classification is managed through an Object-Oriented system that processes individuals' data and outputs results.

## Features

Classification of Individuals: Individuals are classified into specific universes based on rules defined for traits, age, and planet.
Error Handling: The program handles potential NullPointerException errors when certain individual attributes are missing.
JSON Data Handling: Individuals' data is read from JSON files, and the classification results are output as JSON files.
Universes Included:
- Star Wars: Wookie, Ewok
- Marvel: Asgardian
- Hitchhiker's Guide to the Galaxy: Betelgeusian, Vogon
- Lord of the Rings: Elf, Dwarf


## Technical

`input.json` and `test-input.json` (in `resources` folder) are provided for testing the classification functionality.

The results of the classification are written into JSON files in the `my_output` folder.