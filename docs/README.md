# Freddy User Guide

**Freddy** is a command-line personal task manager that helps you efficiently manage todos, deadlines, and events.

## Getting Started

1. Download the `Freddy.jar` file
2. Place the JAR file in an empty folder
3. run the jar file by double click

# Interact with program

## Adding Tasks

### 1. Todo Tasks
**Usage**: `todo [description]` or `t [description]`

**Example**: `todo Complete assignment`

### 2. Deadline Tasks
**Usage**: `deadline [description] /by [time]` or `ddl [description] /by [time]`

**Example**: `deadline Submit report /by 2026-12-31`

### 3. Event Tasks
**Usage**: `event [description] /from [start] /to [end]` or `e [description] /from [start] /to [end]`

**Example**: `event Meeting /from Mon 14:00 /to Mon 16:00`

## Viewing Tasks
**Usage**: `list` or `l`

**Example**: `list`

**Expected output**:

1.[T][ ] Complete assignment

2.[D][ ] Submit report (by: 2024-12-31)

3.[E][ ] Meeting (from: Mon 14:00 to: Mon 16:00)

## Marking Tasks
**Usage**: `mark [number]` or `check [number]`

**Example**: `mark 1`

## Unmarking Tasks
**Usage**: `unmark [number]` or `uncheck [number]`

**Example**: `unmark 1`

## Deleting Tasks
**Usage**: `delete [number]` or `d [number]`

**Example**: `delete 2`

## Finding Tasks
**Usage**: `find [keyword]` or `search [keyword]`

**Example**: `find meeting`

## Data Storage
Freddy automatically saves tasks to `data/Freddy.txt` in the same folder as the JAR file.

## Quick Reference
| Command | Alias | Function |
|---------|-------|----------|
| todo | t | Add todo |
| deadline | ddl | Add deadline |
| event | e | Add event |
| list | l | List tasks |
| mark | check | Mark as done |
| unmark | uncheck | Unmark task |
| delete | d | Delete task |
| find | search | Search tasks |
| bye | - | Exit program |

**Notes**:
- Commands are case-insensitive
- Task numbers start from 1
- Use `bye` to save data properly
- Task status: `[ ]` not done, `[X]` done
- Task types: `[T]` Todo, `[D]` Deadline, `[E]` Event

## Exiting
**Usage**: `bye`

**Example**: `bye`
