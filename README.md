# gbstag-lib : Java library for GBS-files (Game Boy Sound)
<img src="gameboy.png" alt="Game Boy" align="right">

A Java library for reading gbs files and reading / manipulating the tags.

GBS-files are sound files containing ripped chiptune music from Game Boy and
Game Boy Colour games. GBS stands for Game Boy Sound System.


## Features
* :heavy_check_mark: 100% Java (Java 8) :coffee:
* :heavy_check_mark: Supports UTF-8 encoding in the tags!
* Implements <code>Comparable</code> for sorting out of the box!

## How to use it

### Opening a gbs file
```java

Gbs gbsfile = new GbsFile("/tmp/supermarioland.gbs");
Tag tag = gbsfile.getTag();

System.out.println("Version number: " + tag.getVersionNumber());
System.out.println("This gbs file contains: " + tag.getNumberOfSongs() + " songs");
System.out.println("The first one is no. " + tag.getFirstSong());

System.out.println("Author:\t" + tag.getAuthor());
System.out.println("Title:\t" + tag.getTitle());
System.out.println("Copyright:\t" + tag.getCopyright());
```

### Saving a gbs file
```java
gbsfile.save();
```

### Setting tag values
```java
Gbs gbsfile = new GbsFile("/tmp/supermarioland.gbs");
SimpleGbsTag tag = gbsfile.getTag();

tag.setAuthor("Koji Kondo");
tag.setCopyright("2000 Nintendo");
tag.setTitle("Wario Land 5");
```

### Sorting tags
```java
List<ReadOnlySimpleGbsTag> myTags = new ArrayList<>();
myTags.add(superMarioLand);
myTags.add(warioLand3);
myTags.add(donkeyKongLand);
myTags.sort(null); // That's it! :)
```

## Build
This is a Maven project.

To build simply run
```sh
mvn
```


## Development
For command-line or GUI programs see [gbstag](https://www.github.com/ullenius/gbstag) and [jbstag](https://www.github.com/ullenius/jbstag)

### Interface-segregation principle
There are a number of interfaces included for the <code>GbsTag</code> class.

1. <code>Tag</code> - read/write all tags. Reads low-level tags
1. <code>LowLevel</code> - read only, low-level tags
1. <code>ReadOnlyGbsTag</code> - read only, all tags
1. <code>ReadOnlySimpleGbsTag</code> - read only author, title and copyright
1. <code>SimpleGbsTag</code> - read/write author, title and copyright

Please refer to the Javadocs provided for further details.


=======
## Development
For command-line or GUI programs see [gbstag](https://www.github.com/ullenius/gbstag) and [jbstag](https://www.github.com/ullenius/jbstag)

## Licence
LGPL 2.1

See [COPYING](COPYING)

### Libraries and copyright
* Image by [Flappiefh](https://fr.wikipedia.org/wiki/Utilisateur:Flappiefh) (2013) from Wikimedia Commons. [Creative Commons Attribution-Share-Alike 3.0 Unported licence](https://creativecommons.org/licenses/by-sa/3.0/deed.en).
