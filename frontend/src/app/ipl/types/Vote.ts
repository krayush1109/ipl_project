
// src/app/ipl/types/Vote.ts
export class Vote {
    voteId: number;
    email: string;
    category: string;
    cricketerId: number;
    teamId: number;
  
    constructor(voteId: number, email: string, category: string, cricketerId: number, teamId: number) {
      this.voteId = voteId;
      this.email = email;
      this.category = category;
      this.cricketerId = cricketerId;
      this.teamId = teamId;
    }
  
    displayInfo(): void {
      console.log(`Vote ID: ${this.voteId}, Email: ${this.email}`);
    }
  }
  
  // Example usage:
  const vote = new Vote(1, 'john.doe@example.com', 'Best Batsman', 1, 1);
  vote.displayInfo();
  