// src/app/ipl/types/Team.ts
export class Team {
    teamId: number;
    teamName: string;
    location: string;
    ownerName: string;
    establishmentYear: number;
  
    constructor(teamId: number, teamName: string, location: string, ownerName: string, establishmentYear: number) {
      this.teamId = teamId;
      this.teamName = teamName;
      this.location = location;
      this.ownerName = ownerName;
      this.establishmentYear = establishmentYear;
    }
  
    displayInfo(): void {
      console.log(`Team ID: ${this.teamId}, Team Name: ${this.teamName}, Location: ${this.location}`);
    }
  }
  
  // Example usage:
  const team = new Team(1, 'Mumbai Indians', 'Mumbai', 'Reliance Industries', 2008);
  team.displayInfo();
  