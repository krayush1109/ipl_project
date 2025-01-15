

// src/app/ipl/types/Cricketer.ts
export class Cricketer {
    cricketerId: number;
    teamId: number;
    cricketerName: string;
    age: number;
    nationality: string;
    experience: number;
    role: string;
    totalRuns: number;
    totalWickets: number;
  
    constructor(
      cricketerId: number, teamId: number, cricketerName: string, age: number, nationality: string,
      experience: number, role: string, totalRuns: number, totalWickets: number
    ) {
      this.cricketerId = cricketerId;
      this.teamId = teamId;
      this.cricketerName = cricketerName;
      this.age = age;
      this.nationality = nationality;
      this.experience = experience;
      this.role = role;
      this.totalRuns = totalRuns;
      this.totalWickets = totalWickets;
    }
  
    displayInfo(): void {
      console.log(`Cricketer ID: ${this.cricketerId}`);
      console.log(`Team ID: ${this.teamId}`);
      console.log(`Cricketer Name: ${this.cricketerName}`);
    }
  }
  
  // Example usage:
  const cricketer = new Cricketer(1, 1, 'Sachin Tendulkar', 47, 'Indian', 25, 'Batsman', 18426, 154);
  cricketer.displayInfo();
  
